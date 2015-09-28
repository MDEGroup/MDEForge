package org.mdeforge.business.impl;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.DuplicateNameException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.search.jsonMongoUtils.JsonMongoResourceSet;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.security.crypto.codec.Base64;

import com.mongodb.Mongo;

public abstract class CRUDArtifactServiceImpl<T extends Artifact> implements
		CRUDArtifactService<T> {

	@Autowired
	private Mongo mongo;
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private JsonMongoResourceSet jsonMongoResourceSet;
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
	@Value("#{cfgproperties[mongoPrefix]}")
	private String mongoPrefix;
	@Value("#{cfgproperties[jsonArtifactCollection]}")
	private String jsonArtifactCollection;

	protected Class<T> persistentClass;

	public void createIndex() {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);

		TextIndexDefinition textIndex = new TextIndexDefinitionBuilder()
				.onField("name", 20F).onField("description", 10F)
				.onField("authors", 5F).onField("tags", 7F)
				.onField("extractedContents").named("ArtifactIndex").build();

		operations.indexOps(Artifact.class).ensureIndex(textIndex);
	}

	@Override
	public List<T> search(String searchString) throws BusinessException {
		TextCriteria criteria = TextCriteria.forLanguage("en").matching(
				searchString);
		Query query = TextQuery.queryText(criteria).sortByScore()
				.with(new PageRequest(0, 5));
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		List<T> result = operations.find(query, persistentClass);
		return result;
	}

	@Override
	public List<T> orederedSearch(String text) {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);

		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(
				text);

		TextQuery query = new TextQuery(criteria);
		query.setScoreFieldName("score");
		query.sortByScore();

		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c2);

		}
		List<T> artifacts = operations.find(query, persistentClass);
		return artifacts;
	}

	@SuppressWarnings("unchecked")
	public CRUDArtifactServiceImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T findOneById(String idArtifact, User user) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(
				new ObjectId(user.getId()));
		Criteria c3 = Criteria.where("_id").is(idArtifact);
		Criteria publicCriteria = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c3.andOperator(c2.orOperator(c1, publicCriteria)));
		} else
			query.addCriteria(c3.orOperator(c1, publicCriteria));

		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new BusinessException();
		artifact.getFile().setByteArray(
				gridFileMediaService.getFileByte(artifact));

		return artifact;
	}

	@Override
	public T findOneByName(String name, User user) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c3 = Criteria.where("name").is(name);
		Criteria c4 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c3.andOperator(c2.orOperator(c1, c4)));
		} else
			query.addCriteria(c3.orOperator(c1, c4));

		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new BusinessException();
		artifact.getFile().setByteArray(
				gridFileMediaService.getFileByte(artifact));

		return artifact;
	}

	@Override
	public List<T> findAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.find(query, persistentClass);
		} else
			return n.findAll(persistentClass);

	}

	@Override
	public List<T> findRecentArtifacts() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c);
			query.limit(5);
			query.with(new Sort(Sort.Direction.DESC, "created"));
			return n.find(query, persistentClass);
		} else {
			Query q = new Query();
			q.limit(5);
			q.with(new Sort(Sort.Direction.DESC, "created"));
			return n.find(q, persistentClass);
		}

	}

	@Override
	public long countAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.count(query, persistentClass);
		} else
			return n.count(new Query(), persistentClass);

	}

	@Override
	public void delete(String idArtifact, User user) {
		Artifact artifact = findOneByOwner(idArtifact, user);
		for (Project project : artifact.getProjects())
			for (Artifact art : project.getArtifacts())
				if (art.getId().equals(idArtifact)) {
					project.getArtifacts().remove(art);
					project.setModifiedDate(new Date());
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
		for (Relation us : artifact.getRelations()) {
			Relation relationToRemove = relationRepository.findOne(us.getId());

			relationToRemove.getFromArtifact().getRelations()
					.remove(relationToRemove);
			relationToRemove.getToArtifact().getRelations()
					.remove(relationToRemove);

			artifactRepository.save(relationToRemove.getFromArtifact());
			artifactRepository.save(relationToRemove.getToArtifact());
			relationRepository.delete(relationToRemove);
		}

		// TODO delete Relation
		gridFileMediaService.delete(artifact.getFile());
		artifactRepository.delete(artifact);

	}

	@Override
	public void delete(T artifact, User user) {
		artifact = findOneById(artifact.getId(), user);
		for (Project project : artifact.getProjects()) {
			Artifact artToRemove = new Artifact();
			for (Artifact art : project.getArtifacts())
				if (art.getId().equals(artifact.getId()))
					artToRemove = art;
			project.getArtifacts().remove(artToRemove);
			project.setModifiedDate(new Date());
			projectRepository.save(project);

		}
		for (Workspace workspace : artifact.getWorkspaces()) {
			Artifact artToRemove = new Artifact();
			for (Artifact art : workspace.getArtifacts())
				if (art.getId().equals(artifact.getId()))
					artToRemove = art;
			workspace.getArtifacts().remove(artToRemove);
			workspaceRepository.save(workspace);

		}
		for (User us : artifact.getShared()) {
			Artifact artToRemove = new Artifact();
			for (Artifact art : us.getSharedArtifact())
				if (art.getId().equals(artifact.getId()))
					artToRemove = art;

			us.getSharedArtifact().remove(artToRemove);
			userRepository.save(us);
		}

		for (Relation us : artifact.getRelations()) {
			Relation relationToRemove = relationRepository.findOne(us.getId());

			relationToRemove.getFromArtifact().getRelations()
					.remove(relationToRemove);
			relationToRemove.getToArtifact().getRelations()
					.remove(relationToRemove);

			artifactRepository.save(relationToRemove.getFromArtifact());
			artifactRepository.save(relationToRemove.getToArtifact());
			relationRepository.delete(relationToRemove);
		}
		// TODO delete Relation
		gridFileMediaService.delete(artifact.getFile());
		artifactRepository.delete(artifact);

	}

	@Override
	public void update(T artifact) {
		try {
			if (artifact.getId() == null)
				throw new BusinessException();
			// verify metamodel owner
			User user = userRepository.findOne(artifact.getAuthor().getId());
			artifact.setAuthor(user);
			T original = findOneByOwner(artifact.getId(), artifact.getAuthor());
			// UploadFile
			if (artifact.getFile() != null
					&& artifact.getFile().getByteArray() != null) {
				GridFileMedia fileMedia = new GridFileMedia();
				fileMedia.setFileName("");
				fileMedia.setByteArray(Base64.decode(artifact.getFile()
						.getContent().getBytes()));
				gridFileMediaService.delete(original.getFile());
				gridFileMediaService.store(artifact.getFile());
				artifact.setFile(fileMedia);
			} else
				artifact.setFile(original.getFile());

			for (Workspace ws : artifact.getWorkspaces()) {
				workspaceService.findById(ws.getId(), artifact.getAuthor());
			}
			// check project Auth
			for (Project p : artifact.getProjects()) {
				projectService.findById(p.getId(), artifact.getAuthor());
			}

			List<Relation> relationTemp = artifact.getRelations();
			artifact.setRelations(new ArrayList<Relation>());

			artifactRepository.save(artifact);
			// check relation
			for (User us : artifact.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!isArtifactInUser(u, artifact.getId())) {
					u.getSharedArtifact().add(artifact);
					userRepository.save(u);
				}
			}
			for (Relation rel : relationTemp) {

				Artifact toArtifact = artifactRepository.findOne(rel
						.getToArtifact().getId());
				// findOneById(rel.getToArtifact().getId(),
				// artifact.getAuthor());
				if (existRelation(toArtifact.getId(), artifact.getId())) {
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
				if (!isArtifactInWorkspace(w.getId(), artifact.getId())) {
					w.getArtifacts().add(artifact);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : artifact.getProjects()) {
				Project p = projectService.findById(ps.getId(),
						artifact.getAuthor());
				if (!isArtifactInProject(p.getId(), artifact.getId())) {
					p.getArtifacts().add(artifact);
					p.setModifiedDate(new Date());
					projectRepository.save(p);
				}
			}

		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public void updateSimple(T artifact) {
		try {
			artifactRepository.save(artifact);
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public T create(T artifact) throws BusinessException {
		// check workspace Auth
		try {
			if (artifactRepository.findByName(artifact.getName()) != null)
				throw new DuplicateNameException();
			// GetUser
			if (artifact.getId() != null)
				throw new BusinessException();
			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(artifact.getFile().getFileName());
			if (artifact.getFile().getByteArray() != null)
				fileMedia.setByteArray(artifact.getFile().getByteArray());
			else
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
				Artifact toArtifact = artifactRepository.findOne(rel
						.getToArtifact().getId());

				if (!existRelation(toArtifact.getId(), artifact.getId())) {
					rel.setFromArtifact(artifact);
					artifact.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(artifact);
					if (toArtifact.getRelations() == null)
						toArtifact.setRelations(new ArrayList<Relation>());
					toArtifact.getRelations().add(rel);
					artifactRepository.save(toArtifact);
				}
			}
			// Update bi-directional reference
			artifact.setRelations(relationTemp);
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
				p.setModifiedDate(new Date());

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
	public List<T> findAllWithPublicByUser(User user) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(
				new ObjectId(user.getId()));
		Criteria c2 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c3 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c3.orOperator(c2, c1));
		} else
			query.addCriteria(c1.orOperator(c2));
		return n.find(query, persistentClass);
	}

	@Override
	public List<T> findAllPublic() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c1.andOperator(c2));
		} else
			query.addCriteria(c2);
		return n.find(query, persistentClass);
	}

	@Override
	public T findOneByOwner(String idArtifact, User user)
			throws BusinessException {
		T result = findOne(idArtifact);
		if (result == null)
			throw new BusinessException();
		if (result.getAuthor().getId().equals(user.getId()))
			return result;
		else
			throw new BusinessException();
	}

	@Override
	public T findOne(String id) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("id").is(id);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c2.andOperator(c1));
		} else
			query.addCriteria(c2);
		return n.findOne(query, persistentClass);
	}

	@Override
	public T findOnePublic(String id) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("id").is(id);
		Criteria c3 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(new Criteria().andOperator(c1, c2, c3));
		} else
			query.addCriteria(new Criteria().andOperator(c2, c3));
		return n.findOne(query, persistentClass);
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
		List<Relation> r = relationRepository
				.findByFromArtifactIdOrToArtifactId(idFrom, idTo);
		return (r.size() == 0) ? false : true;
	}

	@Override
	public List<T> findArtifactInProject(String idProject, User user) {
		projectService.findById(idProject, user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("projects.$id").is(idProject);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(new Criteria().andOperator(c1, c2));
		} else
			query.addCriteria(c1);
		return operations.find(query, persistentClass);
	}

	@Override
	public List<T> findArtifactInWorkspace(String idWorkspace, User user) {
		workspaceService.findById(idWorkspace, user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("workspaces.$id").is(idWorkspace);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(new Criteria().andOperator(c1, c2));
		} else
			query.addCriteria(c1);
		return operations.find(query, persistentClass);
	}

	protected T findOneByName(String name, User user, Class<T> c)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users.$id").is(user.getId());
		Criteria c3 = Criteria.where("name").is(name);

		if (c != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(c.getCanonicalName());
			query.addCriteria(c1.andOperator(c2).andOperator(c3));
		}
		query.addCriteria(c1.andOperator(c3));
		T project = operations.findOne(query, c);
		if (project == null)
			throw new BusinessException();
		return project;
	}

	@Override
	public T findOneByName(String name) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();

		Criteria c3 = Criteria.where("name").is(name);

		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(new Criteria().andOperator(c2, c3));
		}
		query.addCriteria(c3);
		T artifact = operations.findOne(query, persistentClass);
		// if (artifact == null)
		// throw new ArtifactNotFound();
		return artifact;
	}

	@Override
	public List<Metric> findMetricForArtifact(Artifact a) {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("artifact.$id").is(a.getId());
		query.addCriteria(c1);
		return operations.find(query, Metric.class);

	}

	// TODO Antonio Da eliminare Assolutamente
	@Override
	public Resource loadArtifacrt(String id) throws BusinessException {
		String mongoURI = mongoPrefix + mongo.getAddress().toString() + "/"
				+ mongoDbFactory.getDb().getName() + "/"
				+ jsonArtifactCollection + "/" + id;
		Resource resource = jsonMongoResourceSet.getResourceSet()
				.createResource(URI.createURI(mongoURI));

		try {
			resource.load(null);
		} catch (IOException e) {
			throw new BusinessException();
		}

		return resource;
	}

	@Override
	public List<T> findSharedNoProject(User user) throws BusinessException {

		List<Project> projList = projectService.findByUser(user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(
				new ObjectId(user.getId()));
		Criteria notPublic = Criteria.where("open").is(false);

		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c1.andOperator(c2, notPublic));
		}
		query.addCriteria(c1.andOperator(notPublic));
		List<T> artList = operations.find(query, persistentClass);
		List<T> toRemove = new ArrayList<T>();
		for (T artifactTo : artList) {
			for (Project projectTo : artifactTo.getProjects()) {
				for (Project p : projList) {
					if (p.getId().equals(projectTo.getId()))
						toRemove.add(artifactTo);
				}
			}
		}
		for (Project projectTo : projList) {
			for (Artifact artifactTo : projectTo.getArtifacts()) {
				for (Artifact a : artList) {
					if (artifactTo.getId().equals(a.getId())) {
						toRemove.add((T) artifactTo);
					}
				}
			}
		}
		for (T toRem : toRemove) {
			artList.remove(toRem);
		}
		return artList;
	}

	@Override
	public List<T> findMyArtifacts(User user) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Criteria userCriteria = Criteria.where("author.$id").is(
				new ObjectId(user.getId()));
		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(
					persistentClass.getCanonicalName());
			query.addCriteria(c.andOperator(userCriteria));
			return n.find(query, persistentClass);
		} else {
			query.addCriteria(userCriteria);
			return n.find(query, persistentClass);
		}
	}

	@Override
	public User addUserInArtifact(String idUser, String idArtifact, User user) {
		Artifact art = findOneById(idArtifact, user);
		User us = userRepository.findOne(idUser);
		art.getShared().add(us);
		us.getSharedArtifact().add(art);
		artifactRepository.save(art);
		userRepository.save(us);
		return us;
	}

	@Override
	public void removeUserFromArtifact(String idUser, String idArtifact)
			throws BusinessException {
		User user = userRepository.findOne(idUser);
		Artifact art = artifactRepository.findOne(idArtifact);
		for (Project project : user.getSharedProject()) {
			if (project.getArtifacts().contains(art)) {
				project.getArtifacts().remove(art);
				projectRepository.save(project);
			}
			art.removeFromProjects(project);
		}
		user.getSharedArtifact().remove(art);
		art.getShared().remove(user);
		userRepository.save(user);
		artifactRepository.save(art);
	}
}
