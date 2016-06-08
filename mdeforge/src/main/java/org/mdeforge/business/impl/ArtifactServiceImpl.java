package org.mdeforge.business.impl;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.model.Artifact;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.stereotype.Service;
@Service
public class ArtifactServiceImpl extends CRUDArtifactServiceImpl<Artifact> {

}
