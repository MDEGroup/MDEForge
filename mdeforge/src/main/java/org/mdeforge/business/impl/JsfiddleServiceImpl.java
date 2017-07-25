package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.JsfiddleService;
import org.mdeforge.business.model.Jsfiddle;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.JsfiddleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class JsfiddleServiceImpl implements JsfiddleService{

	
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	
	@Autowired
	private JsfiddleRepository jsfiddleRepository;
	
	@Override
	public void create(Jsfiddle jsfiddle) throws BusinessException {
		// TODO Auto-generated method stub
		
		String test = null;
		test = "";
	}

	@Override
	public List<Jsfiddle> findByUser(User userId) throws BusinessException {
		// TODO Auto-generated method stub
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria.where("users").in(userId.getId()));
		List<Jsfiddle> jsfiddle = operations.find(query, Jsfiddle.class);		
		return jsfiddle;
	}

	@Override
	public Jsfiddle findById(String id, User user) throws BusinessException {
		// TODO Auto-generated method stub
		Jsfiddle j = jsfiddleRepository.findById(id);
		if (j!=null){
			for(User u : j.getUsers()){
				if(u.getId().equals(user.getId())){
					return j;
				}
			}
		}
		throw new BusinessException();
	}

}
