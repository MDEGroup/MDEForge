package org.mdeforge.business.impl;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.bson.types.ObjectId;
import org.mdeforge.business.ArtifactNotFoundException;
import org.mdeforge.business.AuthorizzationException;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.DuplicateNameException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Comment;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.ToBeAnalyse;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.Statistic;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.MetricRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.ToBeAnalyseRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
public abstract class CRUDArtifactServiceImpl<T extends Artifact> implements CRUDArtifactService<T> {
	
	private IndexWriter writer;
	
	@Override
	public ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag, boolean generated) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Criteria userCriteria = Criteria.where("author.$id").is(new ObjectId(user.getId()));
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		query.addCriteria(Criteria.where("generated").is(generated));
		List<T> res;
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			query.addCriteria(userCriteria);
			res = n.find(query, persistentClass);
			total = n.count(new Query().addCriteria(c).addCriteria(userCriteria)
					.addCriteria(Criteria.where("generated").is(generated)), persistentClass);
		} else {
			query.addCriteria(userCriteria);
			res = n.find(query, persistentClass);
			total = n.count(new Query().addCriteria(userCriteria)
					.addCriteria(Criteria.where("generated").is(generated)), persistentClass);
		}
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}

	@Override
	public ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Criteria userCriteria = Criteria.where("author.$id").is(new ObjectId(user.getId()));
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		List<T> res;
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			query.addCriteria(userCriteria);
			res = n.find(query, persistentClass);
			total = n.count(new Query().addCriteria(c).addCriteria(userCriteria), persistentClass);
		} else {
			query.addCriteria(userCriteria);
			res = n.find(query, persistentClass);
			total = n.count(new Query().addCriteria(userCriteria), persistentClass);
		}
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}

	@Override
	public ResponseGrid<T> findAll(RequestGrid pag) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		List<T> res = null;
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			res = n.find(query, persistentClass);
			total = n.count(new Query(c), persistentClass);
			
		} else {
			res = n.find(query, persistentClass);
			total = n.count(new Query(), persistentClass);
		}
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}

	

	@Override
	public ResponseGrid<T> findAllPublic(RequestGrid pag) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		Criteria c2 = Criteria.where("open").is(true);
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			Query q2 = new Query();
			q2.addCriteria(c1);
			q2.addCriteria(c2);
			total = n.count(q2, persistentClass);
		} else {
			query.addCriteria(c2);
			total = n.count(new Query(c2), persistentClass);
		}
		List<T> res = n.find(query, persistentClass);
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}



	@Override
	public ResponseGrid<T> findAllSharedByUser(User user, RequestGrid pag) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		Criteria c2 = Criteria.where("author.$id").is(new ObjectId(user.getId()));
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c3 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.orOperator(c2, c1));
			total = n.count(new Query(c3.orOperator(c2,c1)), persistentClass);
		} else {
			query.addCriteria(new Criteria().orOperator(c1, c2));
			total = n.count(new Query(new Criteria().orOperator(c1, c2)), persistentClass);
		}
		List<T> res = n.find(query, persistentClass);
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}



	@Override
	public ResponseGrid<T> findAllWithPublicByUser(User user, RequestGrid pag) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		Criteria c2 = Criteria.where("open").is(true);
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c3 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.orOperator(c2, c1));
			total = n.count(new Query(c3.orOperator(c2, c1)), persistentClass);
		} else {
			query.addCriteria(new Criteria().orOperator(c2));
			total = n.count(new Query(new Criteria().orOperator(c2)), persistentClass);
		}
		List<T> res = n.find(query, persistentClass);
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}



	@Override
	public ResponseGrid<T> findArtifactInProject(String idProject, User user, RequestGrid pag) {
		projectService.findById(idProject, user);
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.skip(pag.getStart());
		query.limit(pag.getLength());
		Criteria c1 = Criteria.where("projects.$id").is(idProject);
		long total = 0;
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			total = n.count(new Query().addCriteria(c1).addCriteria(c2), persistentClass);
		} else { 
			query.addCriteria(c1);
			total = n.count(new Query(c1), persistentClass);
		}
		List<T> res = n.find(query, persistentClass);
		return new ResponseGrid<>(pag.getDraw(), total, total, res);
	}







	@Override
	public void addComment(Comment comment, String idArtifact) throws BusinessException {
		T art = findOne(idArtifact);
		comment.setId(new ObjectId().toString());
		comment.setUser(userService.findOne(comment.getUser().getId()));
		art.getComments().add(comment);
		artifactRepository.save(art);
		return;
	}

	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private CRUDRelationService<Relation> crudRelationService;
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	protected RelationRepository relationRepository;
	@Autowired
	protected ArtifactRepository artifactRepository;
	@Autowired
	protected ProjectService projectService;
	@Autowired
	protected ToBeAnalyseRepository toBeAnalyzedRepository;
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
	Logger logger = LoggerFactory.getLogger(CRUDArtifactServiceImpl.class);
	protected Class<T> persistentClass;
	@Value("#{cfgproperties[basePathLucene]}")
	protected String basePathLucene;

	//TODO
//	protected Document getMetadataIndex (Artifact artifact){
//		Document doc = new Document();
//		Field idField = new Field(ID_TAG, artifact.getId(), Store.YES, Index.ANALYZED);
//	 	doc.add(idField);
//		
//		Field artifactType = new Field(TYPE_TAG, artifact.getClass().getSimpleName(), Store.YES, Index.ANALYZED);
//		doc.add(artifactType);
//		
//		String text = getTextFromInputStream(gridFileMediaService.getFileInputStream(artifact));
//		Field textField = new Field("text", text, Store.YES, Index.ANALYZED);
//		doc.add(textField);
//
//		
//		Field artName = new Field(NAME_TAG, artifact.getName(), Store.YES, Index.ANALYZED);
//	 	doc.add(artName);
//	 	
//	 	Field authorField = new Field(AUTHOR_TAG, artifact.getAuthor().getUsername(), Store.YES, Index.ANALYZED);
//	 	doc.add(authorField);
//	 	
//	 	Field lastUpdateField = new Field(LAST_UPDATE_TAG, artifact.getModified().toString(), Store.YES, Index.ANALYZED);
//	 	doc.add(lastUpdateField);
//	 	
//	 	for (Property prop : artifact.getProperties()) {
//			String propName = prop.getName();
//			String propValue = prop.getValue();
//			if(propName != null && propValue != null) {
//				Field propField = new Field(propName, propValue, Store.YES, Index.ANALYZED);
//				doc.add(propField);
//			}
//		}
//	 	for (Relation rel : artifact.getRelations()) {
//			if(rel.getFromArtifact()!=artifact){
//				Field involvedName = new Field(INVOLVED_TAG, rel.getFromArtifact().getId(), Store.YES, Index.ANALYZED);
//			 	doc.add(involvedName);
//			 	Field involvedId = new Field(INVOLVED_TAG, rel.getFromArtifact().getId(), Store.YES, Index.ANALYZED);
//			 	doc.add(involvedId);
//			}
//			if(rel.getToArtifact()!=artifact){
//				Field involvedName = new Field(INVOLVED_TAG, rel.getToArtifact().getId(), Store.YES, Index.ANALYZED);
//			 	doc.add(involvedName);
//			 	Field involvedId = new Field(INVOLVED_TAG, rel.getToArtifact().getId(), Store.YES, Index.ANALYZED);
//			 	doc.add(involvedId);
//			}
//		}
//	 	return doc;
//	}

	
	


	

	@SuppressWarnings("unchecked")
	public CRUDArtifactServiceImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public String getTextFromInputStream(InputStream is){      
        String str = "";
        StringBuffer buf = new StringBuffer();            
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {                            
                while ((str = reader.readLine()) != null) {    
                    buf.append(str + "\n" );
                }                
            }
        } catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
            try { is.close(); } catch (Throwable ignore) {}
        }
        return buf.toString();
    }
	
	@Override
	public T findOneById(String idArtifact, User user) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		Criteria c3 = Criteria.where("_id").is(idArtifact);
		Criteria publicCriteria = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.andOperator(c2.orOperator(c1, publicCriteria)));
		} else
			query.addCriteria(c3.orOperator(c1, publicCriteria));

		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		artifact.getFile().setByteArray(gridFileMediaService.getFileByte(artifact));
		artifact.setMetrics(metricRepository.findByArtifactId(new ObjectId(idArtifact)));
		return artifact;
	}

	@Override
	public T findOneInProject(String project_id, String artifact_id, User user) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c3 = Criteria.where("_id").is(artifact_id);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3);
			query.addCriteria(c2);
		} else
			query.addCriteria(c3);
		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		artifact.getFile().setByteArray(gridFileMediaService.getFileByte(artifact));
		Project proj = projectRepository.findOne(project_id);
		artifact.setMetrics(metricRepository.findByArtifactId(new ObjectId(artifact_id)));
		if (proj == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		if (artifact.getProjects().contains(proj))
			return artifact;
		else
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
	}

	@Override
	public T findOneByName(String name, User user) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c3 = Criteria.where("name").is(name);
		Criteria c4 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.andOperator(c2.orOperator(c1, c4)));
		} else
			query.addCriteria(c3.orOperator(c1, c4));

		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		artifact.getFile().setByteArray(gridFileMediaService.getFileByte(artifact));

		return artifact;
	}

	@Override
	public List<T> findAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.find(query, persistentClass);
		} else {
			return n.find(query, persistentClass);
		}

	}

	@Override
	public <K> List<K> findAll(Class<K> k) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c = Criteria.where("_class").is(k.getCanonicalName());
		query.addCriteria(c);
		return n.find(query, k);
	}
	
	@Override
	public List<T> findRecentArtifacts() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
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
	public List<T> findRecentArtifactsPublic() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			Criteria publicCriteria = Criteria.where("open").is(true);
			query.addCriteria(c);
			query.addCriteria(publicCriteria);
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
	public List<Statistic> statistic() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int numDays = 28;
		cal.add(Calendar.DAY_OF_MONTH, -numDays );
		Date dateBefore30Days = cal.getTime();
		
		List<Statistic> result = new ArrayList<Statistic>();
		if (persistentClass != Artifact.class) {
			Aggregation agg = newAggregation(
					match(new Criteria().andOperator(
							Criteria.where("created").gt(dateBefore30Days),
							Criteria.where("_class").
										is(persistentClass.getCanonicalName())
							)
					),
					project("created").andExpression("month(created)").as("month_joined"),
				    group("month_joined").count().as("total"),
				    project("total").and("created").previousOperation(),	 
				    sort(Direction.ASC, "created")			
					);
				AggregationResults<Statistic> groupResults 
					= n.aggregate(agg, Artifact.class, Statistic.class);
				result = groupResults.getMappedResults();
				
		} else {
			Aggregation agg = newAggregation(
					match(Criteria.where("created").gt(dateBefore30Days)),
					project("created").andExpression("month(created)").as("month_joined"),
				    group("month_joined").count().as("total"),
				    project("total").and("created").previousOperation(),	 
				    sort(Direction.ASC, "created")			
					);
				AggregationResults<Statistic> groupResults 
					= n.aggregate(agg, Artifact.class, Statistic.class);
				result = groupResults.getMappedResults();
				
		}
		List<Statistic> stat = new ArrayList<Statistic>();
		for(int k=0; k<numDays; k++ ) {
			
			cal.add(Calendar.DAY_OF_MONTH, 1);
			Statistic t = null;
			for (Statistic statistic : result) {
				if(cal.get(Calendar.DAY_OF_MONTH) == Integer.parseInt(statistic.getCreated()))
					t = statistic;
			}
			if(t != null)
				stat.add(t);
			else {
				Statistic tempStat = new Statistic();
				tempStat.setCreated(cal.get(Calendar.DAY_OF_MONTH)+"");
				tempStat.setTotal("0");
				stat.add(tempStat);
			}
		}
		return stat;
		
	}

	@Override
	public long countAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);

		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.count(query, persistentClass);
		} else
			return n.count(new Query(), persistentClass);

	}
	@Override
	public void deleteComment(String idComment, String idArtifact) {
		T art = findOne(idArtifact);
		Comment c = new Comment();
		c.setId(idComment);
		art.getComments().remove(c);
		artifactRepository.save(art);
		return;
	}

	@Override
	public void delete(T artifact, User user) {
		artifact = findOneById(artifact.getId(), user);
		if(!artifact.getAuthor().getId().equals(user.getId()))
			throw new AuthorizzationException();
		for (Project project : artifact.getProjects()) {
			project.getArtifacts().remove(artifact);
			project.setModifiedDate(new Date());
			projectRepository.save(project);

		}
		for (User us : artifact.getShared()) {
			us.getSharedArtifact().remove(artifact);
			userRepository.save(us);
		}
		artifact.getAuthor().getOwner().remove(artifact);
		userRepository.save(artifact.getAuthor());
		List<Relation> relations = crudRelationService.findRelationsByArtifact(artifact);
		for (Relation us : relations) {
			us.getFromArtifact().getRelations().remove(us);
			us.getToArtifact().getRelations().remove(us);
			artifactRepository.save(us.getFromArtifact());
			artifactRepository.save(us.getToArtifact());
		}
		relationRepository.delete(relations);
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
			if (artifact.getFile() != null && artifact.getFile().getByteArray() != null) {
				GridFileMedia fileMedia = new GridFileMedia();
				fileMedia.setFileName("");
				fileMedia.setByteArray(Base64.decode(artifact.getFile().getContent().getBytes()));
				gridFileMediaService.delete(original.getFile());
				//Todo: Check fix, inverted rows next two lines (Nicola Sacco)
				artifact.setFile(fileMedia);
				gridFileMediaService.store(artifact.getFile());
			} else
				artifact.setFile(original.getFile());

			
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

				Artifact toArtifact = artifactRepository.findOne(rel.getToArtifact().getId());
				// findOneById(rel.getToArtifact().getId(),
				// artifact.getAuthor());
				if (existRelation(toArtifact.getId(), artifact.getId())) {
					rel.setFromArtifact(artifact);
					artifact.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(artifact);
					Artifact temp = artifactRepository.findOne(rel.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}

			
			for (Project ps : artifact.getProjects()) {
				Project p = projectService.findById(ps.getId(), artifact.getAuthor());
				if (!isArtifactInProject(p.getId(), artifact.getId())) {
					p.getArtifacts().add(artifact);
					p.setModifiedDate(new Date());
					projectRepository.save(p);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new BusinessException(e.getMessage());
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
		try {
			if (artifactRepository.findByName(artifact.getName()) != null)
				throw new DuplicateNameException("Duplicate","Duplicate artifact name");
			artifact.setGenerated(false);
			// GetUser
			if (artifact.getId() != null)
				throw new BusinessException();
			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(artifact.getFile().getFileName());
			if (artifact.getFile().getByteArray() != null)
				fileMedia.setByteArray(artifact.getFile().getByteArray());
			else
				fileMedia.setByteArray(Base64.decode(artifact.getFile().getContent().getBytes()));
			artifact.setFile(fileMedia);
			// check workspace Auth
			if (artifact.getProjects() == null)
				artifact.setProjects(new ArrayList<Project>());
			for (Project p : artifact.getProjects()) {
				try {
					projectService.findById(p.getId(), artifact.getAuthor());
				}
				catch(BusinessException e) {
					p.setOwner(artifact.getAuthor());
					p.getUsers().add(artifact.getAuthor());
					projectRepository.save(p);
				}
			}
			if (artifact.getFile() != null) {
				gridFileMediaService.store(artifact.getFile());
			}
			artifact.setCreated(new Date());
			artifact.setModified(new Date());

			User user = userRepository.findOne(artifact.getAuthor().getId());
			artifact.setAuthor(user);
			if (artifact.getShared() == null)
				artifact.setShared(new ArrayList<User>());
			if(!artifact.getShared().contains(user))
				artifact.getShared().add(user);
			List<Relation> relationTemp = artifact.getRelations();
			artifact.setRelations(new ArrayList<Relation>());
			artifactRepository.save(artifact);
			user.getOwner().add(artifact);
			userRepository.save(user);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = artifactRepository.findOne(rel.getToArtifact().getId());

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
			for (Project ps : artifact.getProjects()) {
				Project p = projectService.findById(ps.getId(), artifact.getAuthor());
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
			ToBeAnalyse art = new ToBeAnalyse();
			art.setArtifact(artifact);
			toBeAnalyzedRepository.save(art);

			try{
				createLuceneIndex(artifact);
			} catch(Exception e) {
				logger.error("Error during calculate indexes");
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
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		Criteria c2 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c3 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.orOperator(c2, c1));
		} else
			query.addCriteria(new Criteria().orOperator(c2));
		return n.find(query, persistentClass);
	}

	@Override
	public List<T> findAllSharedByUser(User user) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		Criteria c2 = Criteria.where("author.$id").is(new ObjectId(user.getId()));
		if (persistentClass != Artifact.class) {
			Criteria c3 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c3.orOperator(c2, c1));
		} else
			query.addCriteria(new Criteria().orOperator(c1, c2));
		return n.find(query, persistentClass);
	}

	@Override
	public List<T> findAllPublic() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
		} else
			query.addCriteria(c2);
		return n.find(query, persistentClass);
	}

	@Override
	public T findOneByOwner(String idArtifact, User user) throws BusinessException {
		T result = findOne(idArtifact);
		if (result == null)
			throw new BusinessException();
		if (result.getAuthor().getId().equals(user.getId()))
			return result;
		else
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
	}

	@Override
	public T findOne(String id) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("id").is(id);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c2);
			query.addCriteria(c1);
		} else
			query.addCriteria(c2);
		T art = n.findOne(query, persistentClass);
		if (art == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		return art;
	}

	@Override
	public T findOnePublic(String id) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("id").is(id);
		Criteria c3 = Criteria.where("open").is(true);
		if (persistentClass != Artifact.class) {
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			query.addCriteria(c3);
		} else {
			query.addCriteria(c2);
			query.addCriteria(c3);
		}
		T art = n.findOne(query, persistentClass);
		if (art == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		art.setMetrics(metricRepository.findByArtifactId(new ObjectId(id)));
		return art;
	}


	@Override
	public boolean isArtifactInProject(String idProject, String idArtfact) throws BusinessException {
		Artifact artifact = findOne(idArtfact);
		for (Project workspace : artifact.getProjects()) {
			if (workspace.getId().equals(idProject))
				return true;
		}
		return false;
	}

	@Override
	public boolean isArtifactInUser(User idUser, String idArtfact) throws BusinessException {
		Artifact artifact = findOne(idArtfact);
		for (User user : artifact.getShared()) {
			if (user.getId().equals(idUser.getId()))
				return true;
		}
		return false;
	}

	@Override
	public boolean existRelation(String idTo, String idFrom) throws BusinessException {
		List<Relation> r = relationRepository.findByFromArtifactIdOrToArtifactId(idFrom, idTo);
		return (r.size() == 0) ? false : true;
	}

	@Override
	public List<T> findArtifactInProject(String idProject, User user) {
		projectService.findById(idProject, user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("projects.$id").is(idProject);
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
		} else
			query.addCriteria(c1);
		return operations.find(query, persistentClass);
	}

	protected T findOneByName(String name, User user, Class<T> c) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("users.$id").is(user.getId());
		Criteria c3 = Criteria.where("name").is(name);

		if (c != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(c.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			query.addCriteria(c3);
		} else {
			query.addCriteria(c1);
			query.addCriteria(c3);

		}
		T project = operations.findOne(query, c);
		if (project == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
		return project;
	}

	@Override
	public T findOneByName(String name) throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();

		Criteria c3 = Criteria.where("name").is(name);

		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c2);
			query.addCriteria(c3);
		} else
			query.addCriteria(c3);
		T artifact = operations.findOne(query, persistentClass);
		if (artifact == null)
			throw new ArtifactNotFoundException("Artifact not found",
					"You could be haven't permission to artifact operation");
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

	@Override
	public List<T> findSharedNoProject(User user) throws BusinessException {

		List<Project> projList = projectService.findByUser(user);
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared.$id").is(new ObjectId(user.getId()));
		// Criteria notPublic = Criteria.where("open").is(false);
		Criteria notMine = Criteria.where("author.$id").ne(new ObjectId(user.getId()));
		if (persistentClass != Artifact.class) {
			Criteria c2 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			// query.addCriteria(notPublic);
			query.addCriteria(notMine);
		} else {
			query.addCriteria(c1);
			// query.addCriteria(notPublic);
			query.addCriteria(notMine);
		}
		List<T> artList = operations.find(query, persistentClass);
		List<Artifact> toRemove = new ArrayList<Artifact>();

		for (T artifactTo : artList)
			for (Project p : projList)
				if (artifactTo.getProjects().contains(p))
					toRemove.add(artifactTo);
		for (Project projectTo : projList)
			for (Artifact a : artList)
				if (projectTo.getArtifacts().contains(a))
					toRemove.add(a);
		artList.remove(toRemove);
		return artList;
	}

	@Override
	public List<T> findMyArtifacts(User user) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Criteria userCriteria = Criteria.where("author.$id").is(new ObjectId(user.getId()));
		Query query = new Query();
		if (persistentClass != Artifact.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			query.addCriteria(userCriteria);
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
	public User addUserInPublicArtifact(String idUser, String idArtifact, User user) {
		Artifact art = findOnePublic(idArtifact);
		User us = userRepository.findOne(idUser);
		art.getShared().add(us);
		us.getSharedArtifact().add(art);
		artifactRepository.save(art);
		userRepository.save(us);
		return us;
	}

	@Override
	public void removeUserFromArtifact(String idUser, String idArtifact) throws BusinessException {
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

	@Override
	public List<Metric> findMetric(String idArtifact, User user) throws BusinessException {
		return metricRepository.findByArtifactId(new ObjectId(idArtifact));
	}

	
	/**
	 * Parse Metamodel artifact file in order to extrapolate and index the file to Lucene Index
	 * @param ecoreMetamodel
	 * @return Document
	 */
	@Override
	public List<String> getAllIndexTags() {
		
		Collection<String> result = new HashSet<String>();
		try {
			IndexReader luceneIndexReader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
			result = MultiFields.getIndexedFields(luceneIndexReader);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		List<String> sortedList = new ArrayList<String>(result);
		Collections.sort(sortedList);
		
		sortedList.forEach(x -> System.out.println(x));
		return sortedList;
	}
	@Override
	/**
	 * Delete a Term from Lucene index. It take as input the FIELD_NAME and the FILE_PATH of the file we want to delete.
	 */
	public boolean deleteTermFromIndex(String fieldName, String filePath){
		//TODO Basciani
		
		long numberDeleteTerms = 0;
		boolean result = false;
		
		Term termToDelete = new Term(fieldName, filePath); 
		try {
			numberDeleteTerms = writer.deleteDocuments(termToDelete);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
//		
//		 BooleanQuery.Builder builder = new BooleanQuery.Builder();
//
//		//note year is stored as int , not as string when document is craeted.
//		//if you use Term here which will need 2016 as String, that will not match with documents stored with year as int.
//		 Query yearQuery = IntPoint.newExactQuery("year", 2016);
//		 Query stateQuery = new TermQuery(new Term("STATE", "TX"));
//		 Query cityQuery = new TermQuery(new Term("CITY", "CITY NAME"));
//
//		 builder.add(yearQuery, BooleanClause.Occur.MUST);
//		 builder.add(stateQuery, BooleanClause.Occur.MUST);
//		 builder.add(cityQuery, BooleanClause.Occur.MUST);
//
//		 writer.deleteDocuments(builder.build());
		
		if(numberDeleteTerms > 0){
			result = true;
		}
		
		return result;
	}
	
}
