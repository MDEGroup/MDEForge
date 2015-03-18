package org.mdeforge.business.impl;


import java.util.List;

import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Relation;
import org.mdeforge.integration.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SimilarityRelationServiceImpl implements SimilarityRelationService {

	@Autowired
	private RelationRepository relationRepository;
	
	@Override
	public void save (Relation r) {
		relationRepository.save(r);
	}
	@Override
	public List<Relation> findAll() {
		return relationRepository.findAll();
	}
}
