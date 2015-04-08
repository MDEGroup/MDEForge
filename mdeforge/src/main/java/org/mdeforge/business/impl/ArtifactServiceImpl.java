package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service(value="Artifact")
public class ArtifactServiceImpl implements ArtifactService {
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	protected RelationRepository relationRepository;
	@Autowired
	protected ArtifactRepository artifactRepository;
	@Autowired
	protected ProjectService projectService;
	@Autowired
	protected ProjectRepository projectRepository;
	@Autowired
	protected WorkspaceService workspaceService;
	@Autowired
	protected WorkspaceRepository workspaceRepository;
	@Autowired
	protected UserService userService;
	@Autowired
	protected UserRepository userRepository;
	@Autowired
	protected GridFileMediaService gridFileMediaService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;

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

	protected Artifact findOneById(String idArtifact, User user, Class c)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users").in(user.getId());
		Criteria c2 = Criteria.where("_class").is(c.getCanonicalName());
		Criteria c3 = Criteria.where("_id").is(idArtifact);

		query.addCriteria(c1.andOperator(c2).andOperator(c3));
		Artifact project = operations.findOne(query, c);
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

	
	
	protected Artifact findOneForUser(String idArtifact, User idUser, Class c)
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
		Artifact artifact = findByOwnerEcore(idArtifact, user);
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
		// TODO delete Relation
		gridFileMediaService.delete(artifact.getFile().getId());
		artifactRepository.delete(artifact);

	}
	
	@Override
	public void delete(Artifact artifact, User user) {
		artifact = findOneById(artifact.getId(), user);
		for (Project project : artifact.getProjects())
			for (Artifact art : project.getArtifacts())
				if (art.getId().equals(artifact.getId())) {
					project.getArtifacts().remove(art);
					projectRepository.save(project);
				}
		for (Workspace workspace : artifact.getWorkspaces())
			for (Artifact art : workspace.getArtifacts())
				if (art.getId().equals(artifact.getId())) {
					workspace.getArtifacts().remove(art);
					workspaceRepository.save(workspace);
				}

		for (User us : artifact.getShared())
			for (Artifact art : us.getSharedArtifact())
				if (art.getId().equals(artifact.getId())) {
					us.getSharedArtifact().remove(art);
					userRepository.save(user);
				}
		// TODO delete Relation
		gridFileMediaService.delete(artifact.getFile().getId());
		artifactRepository.delete(artifact);

	}

	@Override
	public void update(Artifact artifact) {
		try {
			if (artifact.getId() == null)
				throw new BusinessException();
			// verify metamodel owner
			findByOwnerEcore(artifact.getId(), artifact.getAuthor());

			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(artifact.getFile()
					.getContent().getBytes()));
			artifact.setFile(fileMedia);

			for (Workspace ws : artifact.getWorkspaces()) {
				workspaceService.findById(ws.getId(), artifact.getAuthor());
			}
			// check project Auth
			for (Project p : artifact.getProjects()) {
				projectService.findById(p.getId(), artifact.getAuthor());
			}
			Artifact transTemp = artifactRepository.findOne(artifact.getId());
			gridFileMediaService.delete(transTemp.getFile().getId());
			if (artifact.getFile() != null) {
				gridFileMediaService.store(artifact.getFile());
			}

			List<Relation> relationTemp = artifact.getRelations();
			artifact.setRelations(new ArrayList<Relation>());
			artifactRepository.save(artifact);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = findOneForUser(rel
						.getToArtifact().getId(), artifact.getAuthor());
				if (existRelation(toArtifact.getId(),
						artifact.getId())) {
					rel.setFromArtifact(artifact);
					artifact.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(artifact);
					Artifact temp = artifactRepository.findOne(rel
							.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}

			for (Workspace ws : artifact.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (!isArtifactInWorkspace(w.getId(),
						artifact.getId())) {
					w.getArtifacts().add(artifact);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : artifact.getProjects()) {
				Project p = projectService.findById(ps.getId(),
						artifact.getAuthor());
				if (!isArtifactInProject(p.getId(),
						artifact.getId())) {
					p.getArtifacts().add(artifact);
					projectRepository.save(p);
				}
			}
			for (User us : artifact.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!isArtifactInUser(u, artifact.getId())) {
					u.getSharedArtifact().add(artifact);
					userRepository.save(u);
				}
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public Artifact create(Artifact artifact) throws BusinessException {
		// check workspace Auth
		try {
			// GetUser
			if (artifact.getId() != null)
				throw new BusinessException();

			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(artifact.getName());
			fileMedia.setByteArray(Base64.decode(artifact.getFile()
					.getContent().getBytes()));
			artifact.setFile(fileMedia);

			// check workspace Auth
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
			artifact.setCreated(new Date());
			artifact.setModified(new Date());

			User user = userRepository.findOne(artifact.getAuthor().getId());
			artifact.setAuthor(user);
			artifact.getShared().add(user);

			List<Relation> relationTemp = artifact.getRelations();
			artifact.setRelations(new ArrayList<Relation>());
			artifactRepository.save(artifact);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = findOneForUser(rel
						.getToArtifact().getId(), artifact.getAuthor());
				if (!existRelation(toArtifact.getId(),
						artifact.getId())) {
					rel.setFromArtifact(artifact);
					artifact.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(artifact);
					Artifact temp = artifactRepository.findOne(rel
							.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}
			// Update bi-directional reference
			artifactRepository.save(artifact);
			for (Workspace ws : artifact.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(artifact);
				workspaceRepository.save(w);
			}
			for (Project ps : artifact.getProjects()) {
				Project p = projectService.findById(ps.getId(),
						artifact.getAuthor());
				p.getArtifacts().add(artifact);
				projectRepository.save(p);
			}
			for (User us : artifact.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(artifact);
				userRepository.save(u);
			}
			return artifact;
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public List<Artifact> findAllWithPublicByUser(User user) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Artifact> result = n.find(query, Artifact.class);
		return result;
	}

	protected List<Artifact> findAllWithPublicByUser(User user, Class type)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		//Criteria c2 = Criteria.where("open").is("true");
		Criteria c3 = Criteria.where("_class").is(type.getCanonicalName());
		query.addCriteria(c1.andOperator(c3));
		List<Artifact> result = n.find(query, type);
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

	protected List<Artifact> findAllPublic(Class c) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("open").is(true);
		Criteria c1 = Criteria.where("_class").is(c.getCanonicalName());
		query.addCriteria(c2);
		List<Artifact> result = n.find(query, c);
		return result;
	}

	// Inizio Alexander
	@Override
	public void upload(Artifact metamodel, MultipartFile file) {
		artifactRepository.save(metamodel);
	}

	// fine Alexander

	@Override
	public Artifact findByOwnerEcore(String idArtifact, User idUser)
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
		for (Relation rel : artifactFrom.getRelations())
			if (rel.getToArtifact().getId().equals(idTo))
				return true;
		return false;
	}

	@Override
	public List<Artifact> findArtifactInProject(String idProject, User user) {
		projectService.findById(idProject, user);
		return artifactRepository.findByProjectId(new ObjectId(idProject));
	}

	@Override
	public ArtifactList findArtifactInWorkspace(String idProject, User user) {
		workspaceService.findById(idProject, user);
		ArtifactList aList = new ArtifactList(
				artifactRepository.findByWorkspaceId(new ObjectId(idProject)));
		return aList;
	}

	@Override
	public Artifact findByName(String name, User user) {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users").in(user.getId());
		Criteria c3 = Criteria.where("name").is(name);

		query.addCriteria(c1.andOperator(c3));
		Artifact project = operations.findOne(query, Artifact.class);
		if (project == null)
			throw new BusinessException();
		return project;
	}

	protected Artifact findByName(String name, User user, Class c)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users").in(user.getId());
		Criteria c2 = Criteria.where("_class").is(c.getCanonicalName());
		Criteria c3 = Criteria.where("name").is(name);

		query.addCriteria(c1.andOperator(c2).andOperator(c3));
		Artifact project = operations.findOne(query, c);
		if (project == null)
			throw new BusinessException();
		return project;
	}

}
