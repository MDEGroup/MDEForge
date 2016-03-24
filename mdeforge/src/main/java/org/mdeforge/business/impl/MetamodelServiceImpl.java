package org.mdeforge.business.impl;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.model.Metamodel;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;

@Service
public class MetamodelServiceImpl extends CRUDArtifactServiceImpl<Metamodel> implements MetamodelService {

	@Override
	public void extractedContent(Metamodel artifact) {
		
	}

	@Override
	public void createIndex(TextIndexDefinition textIndex)
			throws BusinessException {
		
	}

}
