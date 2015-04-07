package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.integration.ArtifactRepository;
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
	private ArtifactRepository artifactRepository;

	@Autowired
	private ProjectService projectSerivce;

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;

	@Override
	public void create(Workspace workspace) throws BusinessException {
		User user = userService.findOne(workspace.getOwner().getId());
		workspace.setOwner(user);
		if (workspace.getId() != null)
			throw new BusinessException();
		List<Project> ps = workspace.getProjects();
		workspace.setProjects(new ArrayList<Project>());
		for (Project p : ps) {
			Project temp = projectSerivce.findById(p.getId(), workspace.getOwner());
			workspace.getProjects().add(temp);
		}
		List<Artifact> as = workspace.getArtifacts();
		workspace.setArtifacts(new ArrayList<Artifact>());
		for (Artifact a : as) {
			Artifact art = ecoreMetamodelService.findOneById(a.getId(), workspace.getOwner());
			workspace.getArtifacts().add(art);
		}
		workspaceRepository.save(workspace);
		for (Project p : workspace.getProjects()) {
			p.getWorkspaces().add(workspace);
			projectRepository.save(p);
		}
		for (Artifact a : workspace.getArtifacts()) {
			a.getWorkspaces().add(workspace);
			artifactRepository.save(a);
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
					.getiDisplayStart(), requestGrid.getiDisplayLength(),
					Direction.ASC, requestGrid.getSortCol()));
		} else
			rows = workspaceRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart(), requestGrid.getiDisplayLength(),
					Direction.DESC, requestGrid.getSortCol()));
		return new ResponseGrid<Workspace>(requestGrid.getsEcho(),
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
		if (workspace.getId() == null)
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
			Artifact m = ecoreMetamodelService.findOneById(a.getId(), workspace.getOwner());
			workspace.getArtifacts().add(m);
		}
		workspaceRepository.save(workspace);
		for (Project p : workspace.getProjects()) {
			p.getWorkspaces().add(workspace);
			projectRepository.save(p);
		}
		for (Artifact a : workspace.getArtifacts()) {
			a.getWorkspaces().add(workspace);
			artifactRepository.save(a);
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
		if (workspace != null && workspace.getOwner().getId().equals(user.getId()))
			workspaceRepository.delete(workspace);
	}

	@Override
	public List<Workspace> findAllByUsernamme(User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("owner").in(user.getId()));
		List<Workspace> project = operations.find(query, Workspace.class);
		return project;
	}

	@Override
	public Workspace findOne(String id) {
		// TODO Auto-generated method stub
		return workspaceRepository.findOne(id);
	}
	@Override
	public Workspace findOneWithUser(String id, String idUser) throws BusinessException{
		// TODO Auto-generated method stub
		Workspace workspace = workspaceRepository.findOne(id);
		if (workspace.getOwner().getId().equals(idUser))
			return workspace;
		else throw new BusinessException();
		
	}
	
//	@Override
//	public void save(Workspace workspace) throws BusinessException {
//		workspaceRepository.save(workspace);
//		
//	}

}
