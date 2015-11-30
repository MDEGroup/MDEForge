package org.mdeforge.business.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service
public class ContainmentRelationServiceImpl extends ValuedRelationServiceImpl<ContainmentRelation> implements ContainmentRelationService {


	
}
