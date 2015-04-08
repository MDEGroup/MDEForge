package org.mdeforge.business.impl;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.integration.MetamodelRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MetamodelServiceImpl extends ArtifactServiceImpl implements MetamodelService {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private MetamodelRepository metamodelRepository;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Override
	public void delete(Metamodel metamodel) {
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
		metamodelRepository.delete(metamodel);

	}

	@Override
	public List<Metamodel> findMetamodelByURI(String URI) {
		return null;
	}

	@Override
	public Metamodel findByName(String name) throws BusinessException {
		return metamodelRepository.findByName(name);
	}

	@Override
	public void update(Metamodel metamodel) {
		try {
			if (metamodel.getId() == null)
				throw new BusinessException();

			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(metamodel.getFile()
					.getContent().getBytes()));
			metamodel.setFile(fileMedia);

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

			metamodel.setModified(new Date());
			metamodelRepository.save(metamodel);
			for (Workspace ws : metamodel.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (!isArtifactInWorkspace(w.getId(),
						metamodel.getId())) {
					w.getArtifacts().add(metamodel);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : metamodel.getProjects()) {
				Project p = projectService.findById(ps.getId(), metamodel.getAuthor());
				if (!isArtifactInProject(p.getId(),
						metamodel.getId())) {
					p.getArtifacts().add(metamodel);
					projectRepository.save(p);
				}
			}
			for (User us : metamodel.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!isArtifactInUser(u,
						metamodel.getId())) {
					u.getSharedArtifact().add(metamodel);
					userRepository.save(u);
				}
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

//	@Override
//	public List<Metamodel> findAll() {
//		return metamodelRepository.findAll();
//	}

	@Override
	public List<Artifact> findAllMetamodels() throws BusinessException {
		return new ArtifactList(metamodelRepository.findAllMetamodels());
	}

	@Override
	public ArtifactList findAllMetamodelsByUserId(User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(user.getId())
				.andOperator(
						Criteria.where("_class").is(
								Metamodel.class.getCanonicalName())));
		List<Metamodel> metamodels = operations.find(query, Metamodel.class);
		return new ArtifactList(metamodels);
	}

	@Override
	public void create(Metamodel metamodel) throws BusinessException {
		// check workspace Auth
		try {
			// GetUser
			if (metamodel.getId() != null)
				throw new BusinessException();

			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(metamodel.getName());
			fileMedia.setByteArray(Base64.decode(metamodel.getFile()
					.getContent().getBytes()));
			metamodel.setFile(fileMedia);

			// check workspace Auth
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
			metamodel.setCreated(new Date());
			metamodel.setModified(new Date());
			
			User user = userRepository.findOne(metamodel.getAuthor().getId());
			metamodel.setAuthor(user);
			metamodel.getShared().add(user);
			
			// Update bi-directional reference
			metamodelRepository.save(metamodel);
			for (Workspace ws : metamodel.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(metamodel);
				workspaceRepository.save(w);
			}
			for (Project ps : metamodel.getProjects()) {
				Project p = projectService.findById(ps.getId(), metamodel.getAuthor());
				p.getArtifacts().add(metamodel);
				projectRepository.save(p);
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
	public ArtifactList findAllWithPublicByUser(User user)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Metamodel> result = n.find(query, Metamodel.class);
		return new ArtifactList(result);
	}

	@Override
	public ArtifactList findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria
				.where("open")
				.is(true)
				.orOperator(
						Criteria.where("_class").is(
								Metamodel.class.getCanonicalName()));
		query.addCriteria(c2);
		List<Metamodel> result = n.find(query, Metamodel.class);
		return new ArtifactList(result);
	}

	// Inizio Alexander
	@Override
	public void upload(Metamodel metamodel, MultipartFile file) {
		metamodelRepository.save(metamodel);
	}

	@Override
	public ResponseGrid<Metamodel> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<Metamodel> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = metamodelRepository.findByOpen(true, new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = metamodelRepository.findByOpen(true, new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<Metamodel>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public void download(Metamodel metamodel) {
	}

	// fine Alexander

	@Override
	public Metamodel findByOwner(String idMetamodel, User user)
			throws BusinessException {
		Metamodel mm = metamodelRepository.findOne(idMetamodel);
		try {
			if (!mm.getAuthor().getId().equals(user.getId()))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;
	}

	@Override
	public Metamodel findOneBySharedUser(String idMetamodel, User user)
			throws BusinessException {
		Metamodel mm = metamodelRepository.findOne(idMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}

	@Override
	public Metamodel findOne(String id) throws BusinessException {
		return metamodelRepository.findOne(id);
	}

	@Override
	public void deleteMetamodel(String idMetamodel, User user) {
		delete(idMetamodel, user);
	}
	@Override
	public ArtifactList findtMetamodelInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		ArtifactList aList = new ArtifactList( metamodelRepository.findByWorkspaceId(new ObjectId(idWorkspace)));
		return aList;
	}
	

	@Override
	public ArtifactList findMetamodelInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		ArtifactList aList = new ArtifactList(metamodelRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}
}
