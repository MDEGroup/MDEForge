package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.model.Metamodel;
import org.springframework.stereotype.Service;

@Service
public class MetamodelServiceImpl extends CRUDArtifactServiceImpl<Metamodel> implements MetamodelService {

	@Override
	public void createLuceneIndex(Metamodel artifact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getTagIndexes() {
		// TODO Auto-generated method stub
		return null;
	}



}
