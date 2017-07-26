package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.springframework.stereotype.Service;
@Service
public class ArtifactServiceImpl extends CRUDArtifactServiceImpl<Artifact> {

	@Override
	public void createLuceneIndex(Artifact artifact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getTagIndexes() {
		// TODO Auto-generated method stub
		return null;
	}

}
