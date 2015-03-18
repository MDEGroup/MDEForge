package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.TransformationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.TransformationRepository;
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
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TransformationServiceImpl implements TransformationService {

	@Autowired
	private TransformationRepository transformationRepository;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ArtifactService artifactService;

	@Autowired
	private ArtifactRepository artifactRepository;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Autowired
	private RelationRepository relationRepository;
	
	
	@Override
	public Transformation findOneBySharedUser(String idMetamodel, User user)
			throws BusinessException {
		Transformation mm = transformationRepository.findOne(idMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}


	public void delete(Transformation metamodel) {
		for (Project p : metamodel.getProjects())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(metamodel.getId()))
					p.getArtifacts().remove(mm);
		for (Workspace p : metamodel.getWorkspaces())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(metamodel.getId()))
					p.getArtifacts().remove(mm);
		for (User p : metamodel.getShared())
			for (Artifact m : p.getSharedArtifact())
				if (m.getId().equals(metamodel.getId()))
					p.getSharedArtifact().remove(m);
		// gridFileMediaService.delete(metamodel.getFile());
		transformationRepository.delete(metamodel);

	}

	@Override
	public Transformation findByName(String name) throws BusinessException {
		return transformationRepository.findByName(name);
	}

	@Override
	public void update(Transformation transformation) {
		try {
			if (transformation.getId() == null)
				throw new BusinessException();
			// verify metamodel owner
			findByOwner(transformation.getId(), transformation.getAuthor()
					.getId());

			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(transformation.getFile()
					.getContent().getBytes()));
			transformation.setFile(fileMedia);

			for (Workspace ws : transformation.getWorkspaces()) {
				workspaceService.findById(ws.getId(), transformation.getAuthor());
			}
			// check project Auth
			for (Project p : transformation.getProjects()) {
				projectService.findById(p.getId(), transformation.getAuthor());
			}
			Transformation transTemp = transformationRepository
					.findOne(transformation.getId());
			gridFileMediaService.delete(transTemp.getFile().getId());
			if (transformation.getFile() != null) {
				gridFileMediaService.store(transformation.getFile());
			}

			List<Relation> relationTemp = transformation.getRelations();
			transformation.setRelations(new ArrayList<Relation>());
			transformationRepository.save(transformation);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = artifactService.findOneForUser(rel
						.getToArtifact().getId(), transformation.getAuthor());
				if (artifactService.existRelation(toArtifact.getId(),
						transformation.getId())) {
					rel.setFromArtifact(transformation);
					transformation.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(transformation);
					Artifact temp = artifactRepository.findOne(rel
							.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}

			for (Workspace ws : transformation.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (!artifactService.isArtifactInWorkspace(w.getId(),
						transformation.getId())) {
					w.getArtifacts().add(transformation);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : transformation.getProjects()) {
				Project p = projectService.findById(ps.getId(), transformation.getAuthor());
				if (!artifactService.isArtifactInProject(p.getId(),
						transformation.getId())) {
					p.getArtifacts().add(transformation);
					projectRepository.save(p);
				}
			}
			for (User us : transformation.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!artifactService.isArtifactInUser(u,
						transformation.getId())) {
					u.getSharedArtifact().add(transformation);
					userRepository.save(u);
				}
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public List<Transformation> findAll() {
		return transformationRepository.findAll();
	}

	@Override
	public List<Transformation> findAllTransformations()
			throws BusinessException {
		return transformationRepository.findAllTransformations();
	}

	@Override
	public ArtifactList findAllTransformationsByUserId(String username)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(username)
				.andOperator(
						Criteria.where("_class").is(
								Transformation.class.getCanonicalName())));
		List<Transformation> metamodels = operations.find(query,
				Transformation.class);
		return new ArtifactList(metamodels);
	}

	@Override
	public void create(Transformation transformation) throws BusinessException {
		try {
			if (transformation.getId() != null)
				throw new BusinessException();
			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(transformation.getFile()
					.getContent().getBytes()));
			transformation.setFile(fileMedia);

			for (Workspace ws : transformation.getWorkspaces()) {
				workspaceService.findById(ws.getId(), transformation.getAuthor());
			}
			// check project Auth
			for (Project p : transformation.getProjects()) {
				projectService.findById(p.getId(), transformation.getAuthor());
			}

			if (transformation.getFile() != null) {
				gridFileMediaService.store(transformation.getFile());
			}
			// Update bi-directional reference
			List<Relation> relationTemp = transformation.getRelations();
			transformation.setRelations(new ArrayList<Relation>());

			User user = userRepository.findOne(transformation.getAuthor().getId());
			transformation.setAuthor(user);
			transformation.getShared().add(user);
			transformationRepository.save(transformation);

			// check relation
			for (Relation rel : relationTemp) {
				artifactService.findByOwner(rel.getToArtifact().getId(),
						transformation.getAuthor());
				rel.setFromArtifact(transformation);
				transformation.getRelations().add(rel);
				relationRepository.save(rel);
				artifactRepository.save(transformation);
				Artifact temp = artifactRepository.findOne(rel.getToArtifact()
						.getId());
				if (temp.getRelations() == null)
					temp.setRelations(new ArrayList<Relation>());
				temp.getRelations().add(rel);
				artifactRepository.save(temp);
			}

			for (Workspace ws : transformation.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(transformation);
				workspaceRepository.save(w);
			}
			for (Project ps : transformation.getProjects()) {
				Project p = projectService.findById(ps.getId(), transformation.getAuthor());
				p.getArtifacts().add(transformation);
				projectRepository.save(p);
			}
			for (Relation rel : transformation.getRelations()) {
				relationRepository.save(rel);
			}

			for (User us : transformation.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(transformation);
				userRepository.save(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public ArtifactList findAllWithPublic(String user)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user);
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Transformation> result = n.find(query, Transformation.class);
		return new ArtifactList(result);
	}

	@Override
	public ArtifactList findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("open")
				.is(true)
				.andOperator(
						Criteria.where("_class").is(
								Transformation.class.getCanonicalName())));

		List<Transformation> result = n.find(query, Transformation.class);
		return new ArtifactList(result);
	}

	// Inizio Alexander
	@Override
	public void upload(Transformation metamodel, MultipartFile file) {
		transformationRepository.save(metamodel);
	}

	@Override
	public ResponseGrid<Transformation> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<Transformation> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = transformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = transformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<Transformation>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public void download(Transformation metamodel) {
	}

	// fine Alexander

	@Override
	public Transformation findByOwner(String idMetamodel, String idUser)
			throws BusinessException {
		Transformation mm = transformationRepository.findOne(idMetamodel);
		try {
			if (!mm.getAuthor().getId().equals(idUser))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;

	}

	@Override
	public Transformation findOne(String id) throws BusinessException {
		return transformationRepository.findOne(id);
	}

	@Override
	public void upload(Transformation transformation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(Transformation transformation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Transformation> findTransformationsBySourceMetamodels(
			Transformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transformation> findTransformationsByTargetMetamodels(
			Transformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransformation(String idMetamodel, User user)
			throws BusinessException {
		artifactService.delete(idMetamodel, user);
	}
	
	@Override
	public ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		ArtifactList aList = new ArtifactList( transformationRepository.findByWorkspaceId(new ObjectId(idWorkspace)));
		return aList;
	}
	@Override
	public ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		ArtifactList aList =  new ArtifactList(transformationRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}

}
