package org.mdeforge.business.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.utils.Utils;
import org.mdeforge.business.impl.event.ProjectChanged;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.softlang.megaParser.model.Megamodel;
import org.softlang.megaParser.parser.MegaParserListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import main.antlr.mega.MegaLexer;
import main.antlr.mega.MegaParser;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private UserService userService;

	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ArtifactRepository artifactRepository;
	
	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Override
	public void delete(Project project, User userId) throws BusinessException {
		for (Workspace w : project.getWorkspaces()){
			w.getProjects().remove(project);
			workspaceRepository.save(w);
		}
		for (User u : project.getUsers()) {
			u.getSharedProject().remove(project);
			userRepository.save(u);
		}
		for (Artifact u : project.getArtifacts()){
			u.getProjects().remove(project);
		}
		projectRepository.delete(project);
	}

	@Override
	public ResponseGrid<Project> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<Project> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = projectRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.ASC, requestGrid.getSortCol()));
		} else {
			rows = projectRepository.findAll(new PageRequest(requestGrid
					.getStart(), requestGrid.getLength(),
					Direction.DESC, requestGrid.getSortCol()));
		}
		return new ResponseGrid<Project>(requestGrid.getDraw(),
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
	public List<Project> findRecent() throws BusinessException {
		Query query = new Query();
		query.limit(5);
		query.with(new Sort(Sort.Direction.DESC, "created"));
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		return n.find(query, Project.class);
			
	}

	@Override
	public List<Project> findByIdWorkspace(String idWorkspace, User user)
			throws BusinessException {
		//
		//
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("workspaces").in(idWorkspace));
		query.addCriteria(Criteria.where("users").in(user.getId()));
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
		project.setCreatedDate(new Date());
		projectRepository.save(project);
		for (Workspace ws : workspaces) {
			Workspace w = workspaceRepository.findOne(ws.getId());
			w.getProjects().add(project);
			workspaceRepository.save(w);
		}
		for (User us : project.getUsers()) {
			User u = userRepository.findOne(us.getId());
			u.getSharedProject().add(project);
			userRepository.save(u);
		}
		for (Artifact art : project.getArtifacts()) {
			Artifact u = artifactRepository.findOne(art.getId());
			u.getProjects().add(project);
			artifactRepository.save(u);
		}
	}

	@Override
	public void update(Project project, User idUser ) throws BusinessException {
		if (project.getId() == null)
			throw new BusinessException();
		Project oldProject = projectRepository.findOne(project.getId());
		if(project.getWorkspaces() == null && project.getWorkspaces().size() == 0)
			throw new BusinessException();
		for (Workspace ws : project.getWorkspaces())
			workspaceService.findById(ws.getId(), idUser);
		for (Artifact ws : project.getArtifacts())
			artifactService.findOneById(ws.getId(), idUser);
		
		List<Workspace> workspaces = project.getWorkspaces();
		project.setModifiedDate(new Date());
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
		eventPublisher.publishEvent(new ProjectChanged(oldProject, project));
	}

	@Override
	public List<Project> findByUser(User idUser) throws BusinessException {
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
	public long countAll() throws BusinessException {
		return projectRepository.count();
	}

	@Override
	public Project findOne(String id) throws BusinessException {
		return projectRepository.findOne(id);
	}

	@Override
	public void removeArtifactFromProject(String idArtifact, String idProject,
			User user) throws BusinessException {
		Project proj = findById(idProject, user);
		Artifact art = artifactService.findOneById(idArtifact, user);
		proj.getArtifacts().remove(art);
		art.getProjects().remove(proj);
		artifactRepository.save(art);
		proj.setModifiedDate(new Date());
		projectRepository.save(proj);
	}

	@Override
	public void removeUserFromProject(String idUser, String idProject, User user)
			throws BusinessException {
		Project proj = findById(idProject, user);
		User userToDelete = userRepository.findOne(idUser);
		proj.getUsers().remove(userToDelete);
		//TOGLIERE DAL PROGETTO IL WS
		userToDelete.getSharedProject().remove(proj);
		for (Workspace w : userToDelete.getWorkspaces()) {
			w.getProjects().remove(proj);
			workspaceRepository.save(w);
			proj.getWorkspaces().remove(w);
		}
		userRepository.save(userToDelete);
		proj.setModifiedDate(new Date());
		projectRepository.save(proj);
	}

	@Override
	public void addArtifactInProject(String idArtifact, String idProject,
			User user) throws BusinessException {
		Project proj = findById(idProject, user);
		Artifact emm = artifactService.findOneById(idArtifact, user);
		emm.getProjects().add(proj);
		proj.getArtifacts().add(emm);
		proj.setModifiedDate(new Date());
		projectRepository.save(proj);
		artifactRepository.save(emm);
	}

	@Override
	public User addUserInProject(String idUser, String idProject, User user) {
		Project proj = findById(idProject, user);
		User us = userService.findOne(idUser);
		us.getSharedProject().add(proj);
		proj.getUsers().add(us);
		userRepository.save(us);
		proj.setModifiedDate(new Date());
		projectRepository.save(proj);
		return us;
	}

	@Override
	public List<Project> findSharedNoWorkspace(User user) throws BusinessException {
		List<Workspace> workList = workspaceService.findByUser(user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users.$id").is(new ObjectId(user.getId()));
		
		query.addCriteria(c1);
		List<Project> projList = operations.find(query, Project.class);
		List<Project> toRemove = new ArrayList<Project>();
		for (Project projectTo : projList) {
			for (Workspace workspaceTo : projectTo.getWorkspaces()) {
				for(Workspace w : workList) {
					if (w.getId().equals(workspaceTo.getId()))
						toRemove.add(projectTo);
				}
			}
		}
		for (Workspace workspaceTo : workList) {
			for (Project projectTo : workspaceTo.getProjects()) {
				for (Project p : projList) {
					if (projectTo.getId().equals(p.getId())) {
						toRemove.add(projectTo);
					}
				}
			}
		}
		for (Project toRem : toRemove) {
			projList.remove(toRem);
		}
		return projList;
	}

	@Override
	public List<Project> findMostSharedProject(User user) {
		List<Project> result =  null;
		//TODO
		
	
		return result;
	}

	@Override
	public Project cloneProject(String userId, String projectToCloneId, String workspaceId) {
		/*
		 * When we clone the project We need remove the old artifact and clone them next time because they are linked to by original project
		 * We need manage those case:
		 * - multiple clone 
		 * -
		 * 
		 */
		Utils utils = new Utils();
		User u = userService.findOne(userId);
		Workspace w = new Workspace();
		
		
		List<Artifact> artifactList = new ArrayList<Artifact>();
		List<Artifact> cloneArtifactList = new ArrayList<Artifact>();
		String myDate= utils.createDate("yyyyMMddHHmmss");
		w = workspaceService.findOne(workspaceId);
		Project project = this.findOne(projectToCloneId);
		Project projectClone = new Project();
		projectClone = project.clone();
		String nameProject = "clone_"+ myDate +"_"+ project.getName();
		artifactList = project.getArtifacts();
		

		projectClone.setOwner(u);
		projectClone.setName(nameProject);
		projectClone.setId(null);
	
		String dirUser = u.getUsername() + File.separator;

		/*
		 * WE clone the artifacts and set up:
		 * the author (user), the name of file (it's composed by
		 */
		for (Artifact artifact : artifactList) {

			GridFileMedia gfmObj = new GridFileMedia();
			String path = new String();
			String filename;

			path = gridFileMediaService.getFilePath(artifact);
			filename = utils.getNameFromPath(path);
			try {
				gfmObj = gridFileMediaService.createObjectFromFile(path, filename);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Artifact artifactClone = new Artifact();
			List<Project> projectClonelist = new ArrayList<Project>();
			projectClonelist = artifactClone.getProjects();
			artifactClone = artifact.clone();
			artifactClone.setFile(gfmObj);
			artifactClone.setAuthor(u);
			artifactClone.setName("clone_" + myDate +"_"+ filename);
			artifactClone.getFile().setFileName(dirUser + "clone_" + myDate +"_"+ filename);
			artifactClone.setId(null);
			

			artifactClone.getProjects().clear();
			gridFileMediaService.getFilePathFromContent(gfmObj);
			 artifactService.create(artifactClone);
			cloneArtifactList.add(artifactClone);

		}
//		deleting old artifacts
		projectClone.getArtifacts().clear();

		List<Workspace> listWorkspace = new ArrayList<Workspace>();
		listWorkspace.add(w);
		projectClone.getWorkspaces().remove(workspaceId);
		projectClone.setWorkspaces(listWorkspace);
		projectClone.setArtifacts(cloneArtifactList);
//		 workspaceService.addProjectInWorkspace(idProject, idWorkspace, user)
		this.create(projectClone, u);
		
		return projectClone;
	}

	@Override
	public Megamodel getMegamodelFromProject(Project project) throws BusinessException {

		String path = "test/sample.mega";
		String pdata = project.getMegamodel();
		ByteArrayInputStream stream = new ByteArrayInputStream(pdata.getBytes());
        ANTLRInputStream antlrStream;
		try {
			antlrStream = new ANTLRInputStream(stream);
			MegaLexer lexer = new MegaLexer(antlrStream);
			CommonTokenStream token = new CommonTokenStream(lexer);
			MegaParser parser = new MegaParser(token);
			ParseTreeWalker treeWalker = new ParseTreeWalker();
			MegaParserListener l = new MegaParserListener();
			treeWalker.walk(l, parser.model());
			
			return l.mega;
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		
	}
	
}
