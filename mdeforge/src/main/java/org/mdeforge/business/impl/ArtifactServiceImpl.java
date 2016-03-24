package org.mdeforge.business.impl;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.model.Artifact;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;
@Service
public class ArtifactServiceImpl extends CRUDArtifactServiceImpl<Artifact> {

	@Override
	public void extractedContent(Artifact artifact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createIndex(TextIndexDefinition textIndex)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}


}
