package org.mdeforge.business.impl.event;

import org.mdeforge.business.model.Project;
import org.springframework.context.ApplicationEvent;

public class ProjectChangedEvent extends ApplicationEvent {

	private Project oldProject;
	private Project newProject;
	
	public ProjectChangedEvent(Project oldProject, Project newProject) {
		super(oldProject);

		this.oldProject = oldProject;
		this.newProject = newProject;
	}
	public Project getOldProject() {
		return oldProject;
	}
	public void setOldProject(Project project) {
		this.oldProject = project;
	}
	public Project getNewProject() {
		return newProject;
	}
	public void setNewProject(Project newProject) {
		this.newProject = newProject;
	}

}
