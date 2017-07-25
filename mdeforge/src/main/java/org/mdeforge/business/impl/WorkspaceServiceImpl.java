package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Jsfiddle;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.JsfiddleRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private JsfiddleRepository jsfiddleRepository; 

	@Autowired
	private ArtifactRepository artifactRepository;

	@Autowired
	private ProjectService projectSerivce;

	@Autowired
	private CRUDArtifactService<Artifact> artifactService;

	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;

	@Override
	public void create(Workspace workspace) throws BusinessException {
		User user = userService.findOne(workspace.getOwner().getId());
		workspace.setOwner(user);
		if (workspace.getId() != null && !workspace.getId().isEmpty())
			throw new BusinessException();
		workspace.setId(null);
		if (workspace.getProjects() == null)
			workspace.setProjects(new ArrayList<Project>());
		List<Project> ps = workspace.getProjects();
		
		workspace.setProjects(new ArrayList<Project>());
		for (Project p : ps) {
			Project temp = projectSerivce.findById(p.getId(), workspace.getOwner());
			workspace.getProjects().add(temp);
		}
		List<Artifact> as = workspace.getArtifacts();
		workspace.setArtifacts(new ArrayList<Artifact>());
		for (Artifact a : as) {
			Artifact art = artifactService.findOneById(a.getId(), workspace.getOwner());
			workspace.getArtifacts().add(art);
		}
		workspaceRepository.save(workspace);
		for (Project p : workspace.getProjects()) {
			p.getWorkspaces().add(workspace);
			p.setModifiedDate(new Date());
			projectRepository.save(p);
		}
		
		user.getWorkspaces().add(workspace);
		userRepository.save(user);
	}

	@Override
	public void delete(Workspace workspace) throws BusinessException {
		workspaceRepository.delete(workspace);
	}

	@Override
	public ResponseGrid<Workspace> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<Workspace> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = workspaceRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.ASC, requestGrid.getSortCol()));
		} else
			rows = workspaceRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.DESC, requestGrid.getSortCol()));
		return new ResponseGrid<Workspace>(requestGrid.getDraw(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}
	
	@Override
	public ResponseGrid<Workspace> findAllPaginatedByOwner(RequestGrid requestGrid, User user)
			throws BusinessException {
		Page<Workspace> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = workspaceRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.ASC, requestGrid.getSortCol()), user.getId());
		} else
			rows = workspaceRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.DESC, requestGrid.getSortCol()));
		return new ResponseGrid<Workspace>(requestGrid.getDraw(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}
	@Override
	public Workspace findByName(String name) throws BusinessException {
		return workspaceRepository.findByName(name);
	}

	@Override
	/*
	 * Per il momento ha una funzione additiva
	 */
	public void update(Workspace workspace) throws BusinessException {
		User user = userService.findOne(workspace.getOwner().getId());
		workspace.setOwner(user);
		if (workspace.getId().isEmpty())
			throw new BusinessException();
		List<Project> ps = workspace.getProjects();
		findById(workspace.getId(), user);
		workspace.setProjects(new ArrayList<Project>());
		for (Project p : ps) {
			Project temp = projectSerivce.findById(p.getId(), workspace.getOwner());
			workspace.getProjects().add(temp);
		}
		List<Artifact> as = workspace.getArtifacts();
		workspace.setArtifacts(new ArrayList<Artifact>());
		for (Artifact a : as) {
			Artifact m = artifactService.findOneById(a.getId(), workspace.getOwner());
			workspace.getArtifacts().add(m);
		}
		workspaceRepository.save(workspace);
		for (Project p : workspace.getProjects()) {
			p.getWorkspaces().add(workspace);
			p.setModifiedDate(new Date());
			projectRepository.save(p);
		}
		user.getWorkspaces().add(workspace);
		userRepository.save(user);
	}

	@Override
	public Workspace findById(String id, User user) {

		Workspace ws = workspaceRepository.findById(id);
		if (ws != null && ws.getOwner().getId().equals(user.getId()))
			return ws;
		else
			throw new BusinessException();

	}

	@Override
	public List<Workspace> findAll() throws BusinessException {
		return workspaceRepository.findAll();
	}

	@Override
	public void delete(String id, User user) throws BusinessException {
		Workspace workspace = workspaceRepository.findOne(id);
		if (workspace != null && workspace.getOwner().getId().equals(user.getId())) {
			for (Project proj : workspace.getProjects()) {
				proj.getWorkspaces().remove(workspace);
				projectRepository.save(proj);
				
			}
			workspace.getOwner().getWorkspaces().remove(workspace);
			userRepository.save(workspace.getOwner());
			workspaceRepository.delete(workspace);
			
		}
		
	}

	@Override
	public List<Workspace> findByUser(User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("owner").in(user.getId()));
		List<Workspace> project = operations.find(query, Workspace.class);
		return project;
	}

	@Override
	public Workspace findOne(String id) {
		return workspaceRepository.findOne(id);
	}
	@Override
	public Workspace findOneWithUser(String id, String idUser) throws BusinessException{
		Workspace workspace = workspaceRepository.findOne(id);
		if (workspace.getOwner().getId().equals(idUser))
			return workspace;
		else throw new BusinessException();
		
	}

	@Override
	public List<Project> findProjectInWorkspace(String id, User user) {
		Workspace w = findById(id, user);
		return w.getProjects();
	}

	@Override
	public void removeProjectFromWorkspace(String idProject, String idWorkspace, User user) {
		Workspace w = findById(idWorkspace, user);
		Project p = projectSerivce.findById(idProject, user);
		p.getWorkspaces().remove(w);
		w.getProjects().remove(p);
		projectRepository.save(p);
		workspaceRepository.save(w);
	}

	@Override
	public Project addProjectInWorkspace(String idProject, String idWorkspace,
			User user) throws BusinessException {
		Workspace w = findById(idWorkspace, user);
		Project p = projectSerivce.findById(idProject, user);
		p.getWorkspaces().add(w);
		w.getProjects().add(p);
		p.setModifiedDate(new Date());
		projectRepository.save(p);
		workspaceRepository.save(w);
		return p;
	}

	@Override
	public Project addNewProjectInWorkspace(String projectName,
			String idWorkspace, User user) throws BusinessException {
		user = userService.findOne(user.getId());
		Workspace w = findById(idWorkspace, user);
		Project p = new Project();
		p.setName(projectName);
		p.getWorkspaces().add(w);
		p.setOwner(user);
		p.getUsers().add(user);
		user.getSharedProject().add(p);
		p.setModifiedDate(new Date());
		p.setCreatedDate(p.getModifiedDate());
		projectRepository.save(p);
		w.getProjects().add(p);
		workspaceRepository.save(w);
		return p;
	}
	@Override
	public Project addNewProjectInWorkspace(Project projectName,
			String idWorkspace, User user) throws BusinessException {
		user = userService.findOne(user.getId());
		Workspace w = findById(idWorkspace, user);
		projectName.setOwner(user);
		projectName.getUsers().add(user);
		projectName.setModifiedDate(new Date());
		projectName.setCreatedDate(new Date());
		projectRepository.save(projectName);
		user.getSharedProject().add(projectName);
		w.getProjects().add(projectName);
		workspaceRepository.save(w);
		return projectName;
	}

	@Override
	public Jsfiddle addNewJsfiddleInWorkspace(Jsfiddle jsfiddle, String idWorkspace, User user)
			throws BusinessException {
		user = userService.findOne(user.getId());
		Workspace w = findById(idWorkspace, user);
		jsfiddle.setOwner(user);
		jsfiddle.getUsers().add(user);
		jsfiddle.setModifiedDate(new Date());
		jsfiddle.setCreatedDate(new Date());
		jsfiddleRepository.save(jsfiddle);
		w.getJsfiddles().add(jsfiddle);
		workspaceRepository.save(w);
		return jsfiddle;
	}
}
