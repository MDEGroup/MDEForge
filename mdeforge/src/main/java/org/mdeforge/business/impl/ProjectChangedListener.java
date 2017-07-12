package org.mdeforge.business.impl;

import org.mdeforge.business.impl.event.ProjectChanged;
import org.mdeforge.integration.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
@Component
public class ProjectChangedListener implements ApplicationListener<ProjectChanged> {

	@Autowired
    private ProjectRepository projectRepository;
    Logger logger = LoggerFactory.getLogger(ProjectChangedListener.class);
    @Override
    public void onApplicationEvent(ProjectChanged event) {
    	logger.debug("Ci Sono");
    }
}
