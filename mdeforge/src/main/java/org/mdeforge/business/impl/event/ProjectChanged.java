package org.mdeforge.business.impl.event;

import org.mdeforge.business.model.Project;
import org.springframework.context.ApplicationEvent;

public class ProjectChanged extends ApplicationEvent {

	private Project oldProject;
	private Project newProject;
	
	public ProjectChanged(Project oldProject, Project newProject) {
		super(oldProject);

		this.oldProject = oldProject;
		this.newProject = newProject;
	}
	public Project getProject() {
		return oldProject;
	}
	public void setProject(Project project) {
		this.oldProject = project;
	}
	public Project getNewProject() {
		return newProject;
	}
	public void setNewProject(Project newProject) {
		this.newProject = newProject;
	}

}
