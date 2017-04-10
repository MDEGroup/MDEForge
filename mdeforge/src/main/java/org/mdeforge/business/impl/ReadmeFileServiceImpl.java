package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ReadmeFileService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.ReadmeFile;
import org.springframework.stereotype.Service;
@Service
public class ReadmeFileServiceImpl extends CRUDArtifactServiceImpl<ReadmeFile> implements ReadmeFileService {

	@Override
	public List<Metric> calculateMetrics(Artifact emm) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
