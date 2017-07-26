package org.mdeforge.business.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.mdeforge.business.ProjectService;
import org.mdeforge.business.impl.event.ProjectChangedEvent;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.integration.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.softlang.megaParser.model.Megamodel;
import org.softlang.megaParser.model.RelatesTo;
import org.softlang.megaParser.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProjectChangedListener implements ApplicationListener<ProjectChangedEvent> {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectService projectService;
	Logger logger = LoggerFactory.getLogger(ProjectChangedListener.class);

	@Override
	public void onApplicationEvent(ProjectChangedEvent event) {
		logger.debug("Ci Sono");
		Project newProject = event.getNewProject();
		Project oldProject = event.getOldProject();
		Megamodel m = projectService.getMegamodelFromProject(oldProject);
		Set<Relation> k = m.relations;
		Set<RelatesTo> v = m.relatesTos;
		List<RelatesTo> pp = m.relatesTos.stream().filter(z->z.name.equals("conformTo")).collect(Collectors.toList());
		for (RelatesTo relatesTo : m.relatesTos) {
			
		}
		for (Map.Entry<String, org.softlang.megaParser.model.Artifact> iterable_element : m.models.entrySet()) {

			System.out.println(iterable_element.getValue().link);
		}
		oldProject.getArtifacts().removeAll(newProject.getArtifacts());
		for (Artifact iterable_element : oldProject.getArtifacts()) {
			;
		}

	}
}
