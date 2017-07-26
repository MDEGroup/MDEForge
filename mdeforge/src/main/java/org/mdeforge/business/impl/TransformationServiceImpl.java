package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.TransformationService;
import org.mdeforge.business.model.Transformation;
import org.springframework.stereotype.Service;

@Service
public class TransformationServiceImpl extends CRUDArtifactServiceImpl<Transformation> implements TransformationService {

	@Override
	public void createLuceneIndex(Transformation artifact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getTagIndexes() {
		// TODO Auto-generated method stub
		return null;
	}

}
