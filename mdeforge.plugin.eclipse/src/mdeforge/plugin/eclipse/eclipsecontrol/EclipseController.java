package mdeforge.plugin.eclipse.eclipsecontrol;

import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.mdeforge.business.model.Artifact;

public class EclipseController {
	

	public static void downloadProject(String name, List<Artifact> artifacts) throws CoreException{
		
		
		// Decide whether to create the project in the workspace 
		// or at an external location. 
		boolean createAtExternalLocation = false; 
		// For projects in the workspace, null is passed as the location. 
		IPath projectLocation = null; 
		if (createAtExternalLocation) { 
		projectLocation = new Path("/some/external/location"); 
		} 
		
		String projectName = "myProject"; 
		// Get the project handle (no project created yet). 
		IProject project = 
		ResourcesPlugin.getWorkspace().getRoot().getProject(projectName); 

		// Get a new project description and set the appropriate location. 
		IProjectDescription description = 
		ResourcesPlugin.getWorkspace().newProjectDescription(project.getName()); 
		description.setLocation(projectLocation); 

		// Create and open the project. 
		project.create(description, null); 
		project.open(null); 
		
	}
	
}
