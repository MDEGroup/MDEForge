package org.mdeforge.business.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArtifactServiceImpl implements ArtifactService {
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private ArtifactRepository artifactRepository;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Override
	public Artifact findOneById(String idArtifact, User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("users").in(user.getId()));
		Artifact project = operations.findOne(query, Artifact.class);
		if (project == null)
			throw new BusinessException();
		return project;
	}

	@Override
	public Artifact findOneForUser(String idArtifact, User idUser)
			throws BusinessException {
		Artifact art = artifactRepository.findOne(idArtifact);
		boolean finded = false;
		if (art != null)
			for (User user : art.getShared())
				if (user.getId().equals(idUser.getId()))
					finded = true;
		if (finded == false)
			throw new BusinessException();
		return art;
	}

	@Override
	public List<Artifact> findAll() {
		return artifactRepository.findAll();
	}

	@Override
	public void delete(String idArtifact, User user) {
		Artifact artifact = findByOwner(idArtifact, user);
		for (Project project : artifact.getProjects())
			for (Artifact art : project.getArtifacts())
				if (art.getId().equals(idArtifact)) {
					project.getArtifacts().remove(art);
					projectRepository.save(project);
				}
		for (Workspace workspace : artifact.getWorkspaces())
			for (Artifact art : workspace.getArtifacts())
				if (art.getId().equals(idArtifact)) {
					workspace.getArtifacts().remove(art);
					workspaceRepository.save(workspace);
				}

		for (User us : artifact.getShared())
			for (Artifact art : us.getSharedArtifact())
				if (art.getId().equals(idArtifact)) {
					us.getSharedArtifact().remove(art);
					userRepository.save(user);
				}
		gridFileMediaService.delete(artifact.getFile().getId());
		artifactRepository.delete(artifact);

	}

	

	@Override
	public void update(Artifact metamodel) {
		try {
			if (metamodel.getId() == null)
				throw new BusinessException();
			// verify metamodel owner
			findByOwner(metamodel.getId(), metamodel.getAuthor());

			for (Workspace ws : metamodel.getWorkspaces()) {
				workspaceService.findById(ws.getId(), metamodel.getAuthor());
			}
			// check project Auth
			for (Project p : metamodel.getProjects()) {
				projectService.findById(p.getId(), metamodel.getAuthor());
			}
			if (metamodel.getFile() != null) {
				gridFileMediaService.store(metamodel.getFile());
			}
			// metamodel.g
			artifactRepository.save(metamodel);
			for (Workspace ws : metamodel.getWorkspaces()) {
				Workspace w = workspaceRepository.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(metamodel);
				workspaceRepository.save(w);
			}
			for (Project ps : metamodel.getProjects()) {
				Project p = projectService.findById(ps.getId(), metamodel
						.getAuthor());
				p.getArtifacts().add(metamodel);
				projectService.create(p, metamodel.getAuthor());
			}
			for (User us : metamodel.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(metamodel);
				userRepository.save(u);
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public void create(Artifact artifact) throws BusinessException {
		// check workspace Auth
		try {
			// GetUser
			if (artifact.getId() != null)
				throw new BusinessException();

			for (Workspace ws : artifact.getWorkspaces()) {
				workspaceService.findById(ws.getId(), artifact.getAuthor());
			}
			// check project Auth
			for (Project p : artifact.getProjects()) {
				projectService.findById(p.getId(), artifact.getAuthor());
			}
			if (artifact.getFile() != null) {
				gridFileMediaService.store(artifact.getFile());
			}
			// metamodel.g
			User user = userRepository.findOne(artifact.getAuthor().getId());
			artifact.setAuthor(user);
			artifact.getShared().add(user);
			artifactRepository.save(artifact);
			for (Workspace ws : artifact.getWorkspaces()) {
				Workspace w = workspaceRepository.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(artifact);
				workspaceRepository.save(w);
			}
			for (Project ps : artifact.getProjects()) {
				Project p = projectRepository.findOne(ps.getId());
				p.getArtifacts().add(artifact);
				projectRepository.save(p);
			}
			for (User us : artifact.getShared()) {
				User u = userRepository.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(artifact);
				userRepository.save(u);
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public List<Artifact> findAllWithPublic(User user)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Artifact> result = n.find(query, Artifact.class);
		return result;
	}

	@Override
	public List<Artifact> findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("open").is(true);
		query.addCriteria(c2);
		List<Artifact> result = n.find(query, Artifact.class);
		return result;
	}

	// Inizio Alexander
	@Override
	public void upload(Artifact metamodel, MultipartFile file) {
		artifactRepository.save(metamodel);
	}

	@Override
	public void download(Artifact metamodel) {
	}

	// fine Alexander

	@Override
	public Artifact findByOwner(String idArtifact, User idUser)
			throws BusinessException {
		Artifact mm = artifactRepository.findOne(idArtifact);
		try {
			if (!mm.getAuthor().getId().equals(idUser.getId()))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;

	}

	@Override
	public Artifact findOne(String id) throws BusinessException {
		return artifactRepository.findOne(id);
	}

	@Override
	public boolean isArtifactInWorkspace(String idWorkspace, String idArtfact)
			throws BusinessException {
		Artifact artifact = findOne(idArtfact);
		for (Workspace workspace : artifact.getWorkspaces()) {
			if (workspace.getId().equals(idWorkspace))
				return true;
		}
		return false;
	}

	@Override
	public boolean isArtifactInProject(String idProject, String idArtfact)
			throws BusinessException {
		Artifact artifact = findOne(idArtfact);
		for (Project workspace : artifact.getProjects()) {
			if (workspace.getId().equals(idProject))
				return true;
		}
		return false;
	}

	@Override
	public boolean isArtifactInUser(User idUser, String idArtfact)
			throws BusinessException {
		Artifact artifact = findOne(idArtfact);
		for (User user : artifact.getShared()) {
			if (user.getId().equals(idUser.getId()))
				return true;
		}
		return false;
	}

	@Override
	public boolean existRelation(String idTo, String idFrom)
			throws BusinessException {
		Artifact artifactFrom = findOne(idFrom);
		for(Relation rel : artifactFrom.getRelations())
			if (rel.getToArtifact().getId().equals(idTo))
				return true;
		return false;
	}

	@Override
	public ArtifactList findArtifactInProject(String idProject, User user) {
		projectService.findById(idProject, user);
		ArtifactList aList =  new ArtifactList(artifactRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}
	
	@Override
	public ArtifactList findArtifactInWorkspace(String idProject, User user) {
		workspaceService.findById(idProject, user);
		ArtifactList aList =  new ArtifactList(artifactRepository.findByWorkspaceId(new ObjectId(idProject)));
		return aList;
	}

}
