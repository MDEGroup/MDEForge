package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
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
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ArtifactService artifactService;
	
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private UserService userService;

	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ArtifactRepository artifactRepository;

	@Override
	public void delete(Project project, User userId) throws BusinessException {
		for (Workspace w : project.getWorkspaces())
			for (Project p : w.getProjects()) {
				Project appProg = findOne(p.getId());
				if (p.getId().equals(project.getId())) {
					Workspace app = workspaceService.findOne(w.getId());
					app.getProjects().remove(appProg);
					workspaceRepository.save(w);
					break;
				}
			}
		for (User u : project.getUsers())
			for (Project p : u.getSharedProject()) {
				Project appProg = findOne(p.getId());
				if (p.getId().equals(project.getId())) {
					User app = userService.findOne(u.getId());
					app.getSharedProject().remove(appProg);
					userRepository.save(u);
					break;
				}
			}
		for (Artifact u : project.getArtifacts())
			for (Project p : u.getProjects()) {
				Project appProg = findOne(p.getId());
				if (p.getId().equals(project.getId())) {
					Artifact app = artifactService.findOneById(u.getId(), userId);
					app.getProjects().remove(appProg);
					artifactRepository.save(u);
					break;
				}
			}
		projectRepository.delete(project);

	}

	@Override
	public ResponseGrid<Project> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<Project> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = projectRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart(), requestGrid.getiDisplayLength(),
					Direction.ASC, requestGrid.getSortCol()));
		} else {
			rows = projectRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart(), requestGrid.getiDisplayLength(),
					Direction.DESC, requestGrid.getSortCol()));
		}
		return new ResponseGrid<Project>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public Project findByName(String name) throws BusinessException {
		return projectRepository.findByName(name);
	}

	@Override
	public Project findById(String id, User user) throws BusinessException {
		Project p = projectRepository.findById(id);
		if (p != null)
			for (User u : p.getUsers()) {
				if (u.getId().equals(user.getId()))
					return p;
			}
		throw new BusinessException();
	}

	@Override
	public List<Project> findByIdWorkspace(String idWorkspace, User user)
			throws BusinessException {
		//
		//
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("workspaces").in(idWorkspace)
				.andOperator(Criteria.where("users").in(user.getId())));
		List<Project> project = operations.find(query, Project.class);
		return project;
	}

	@Override
	public void create(Project project, User user) throws BusinessException {
		user = userService.findOne(user.getId());
		if (project.getId() != null)
			throw new BusinessException();
		if(project.getWorkspaces() == null && project.getWorkspaces().size() == 0)
			throw new BusinessException();
		for (Workspace ws : project.getWorkspaces())
			workspaceService.findById(ws.getId(), user);
		for (Artifact ws : project.getArtifacts())
			artifactService.findOneById(ws.getId(), user);

		List<Workspace> workspaces = project.getWorkspaces();
		project.getUsers().clear();
		project.getUsers().add(user);
		projectRepository.save(project);
		for (Workspace ws : workspaces) {
			Workspace w = workspaceRepository.findOne(ws.getId());
			ws.getProjects().add(project);
			workspaceRepository.save(w);
		}
		for (User us : project.getUsers()) {
			User u = userRepository.findOne(us.getId());
			us.getSharedProject().add(project);
			userRepository.save(u);
		}
		for (Artifact art : project.getArtifacts()) {
			Artifact u = artifactRepository.findOne(art.getId());
			art.getProjects().add(project);
			artifactRepository.save(u);
		}
	}

	@Override
	public void update(Project project, User idUser ) throws BusinessException {
		if (project.getId() == null)
			throw new BusinessException();
		if(project.getWorkspaces() == null && project.getWorkspaces().size() == 0)
			throw new BusinessException();
		for (Workspace ws : project.getWorkspaces())
			workspaceService.findById(ws.getId(), idUser);
		for (Artifact ws : project.getArtifacts())
			artifactService.findOneById(ws.getId(), idUser);
		
		List<Workspace> workspaces = project.getWorkspaces();
		projectRepository.save(project);
		for (Workspace ws : workspaces) {
			Workspace w = workspaceRepository.findOne(ws.getId());
			ws.getProjects().add(project);
			workspaceRepository.save(w);
		}
		for (User user : project.getUsers()) {
			User u = userRepository.findOne(user.getId());
			user.getSharedProject().add(project);
			userRepository.save(u);
		}
		for (Artifact art : project.getArtifacts()) {
			Artifact u = artifactRepository.findOne(art.getId());
			art.getProjects().add(project);
			artifactRepository.save(u);
		}
	}

	@Override
	public List<Project> findByIdUser(User idUser) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("users").in(idUser.getId()));
		List<Project> project = operations.find(query, Project.class);
		return project;
	}

	@Override
	public List<Project> findAll() throws BusinessException {
		return projectRepository.findAll();
	}

	@Override
	public Project findOne(String id) throws BusinessException {
		return projectRepository.findOne(id);
	}

}
