package org.mdeforge.business.impl;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.TransformationService;
import org.mdeforge.business.model.Transformation;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;

@Service
public class TransformationServiceImpl extends CRUDArtifactServiceImpl<Transformation> implements TransformationService {

	@Override
	public void extractedContent(Transformation artifact) {
		
	}

	@Override
	public void createIndex(TextIndexDefinition textIndex)
			throws BusinessException {
		
	}

}
