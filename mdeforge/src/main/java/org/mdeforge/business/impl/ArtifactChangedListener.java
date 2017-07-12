package org.mdeforge.business.impl;

import org.mdeforge.business.impl.event.ArtifactChanged;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class ArtifactChangedListener implements ApplicationListener<ArtifactChanged> {

	@Autowired
    private ArtifactRepository artifactRepository;
    Logger logger = LoggerFactory.getLogger(ArtifactChangedListener.class);
    @Override
    public void onApplicationEvent(ArtifactChanged event) {
    	logger.debug("Ci Sono Artifact");
    }
}
