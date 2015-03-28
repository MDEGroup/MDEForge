package org.mdeforge.search.jsonMongoUtils;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoUtil {

	private static MongoUtil instance=null;
	private DB db = null;
	public static final String DB_NAME = "prova01";
	
	private MongoUtil(){
		try {
			MongoClient mongoClient = new MongoClient();
			db = mongoClient.getDB(DB_NAME);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static MongoUtil getInstance(){
		if (instance==null){
			instance = new MongoUtil();
		}
		return instance;
	}
	
	public DBCollection getCollection(String collectionName){
		DBCollection coll = db.getCollection(collectionName);
		
		String indexName = "ArtifactIndex";
		Boolean indexExists = false;

		List<DBObject> indexes = coll.getIndexInfo();
		
		for (DBObject dbo : indexes)
			indexExists = dbo.get("name").equals(indexName);
		
		if (!indexExists){
			coll.createIndex(new BasicDBObject("name", "text")
					.append("description", "text")
					.append("authors", "text"),
				new BasicDBObject("weights",
						new BasicDBObject("name", 20)
							.append("description", 10)
							.append("tags", 7)
							.append("authors", 5)
							.append("contents", 1))
					.append("name", indexName));
		}
		
		return coll;
	}
}
