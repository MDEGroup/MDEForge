package mdeforge.plugin.eclipse.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class MDEForgeNature implements IProjectNature {

	/**
	 * ID of this project nature
	 */
	public static final String NATURE_ID = "mdeforge.plugin.eclipse.mdeforgeNature";

	private IProject project;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#configure()
	 */
	public void configure() throws CoreException {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if(firstElement instanceof IAdaptable){
				IProject project = (IProject)((IAdaptable) firstElement).getAdapter(IProject.class);
				IProjectDescription description = project.getDescription();
				String[] natures = description.getNatureIds();
			    String[] newNatures = new String[natures.length + 1];
			    System.arraycopy(natures, 0, newNatures, 0, natures.length);
			    newNatures[natures.length] = "mdeforge.plugin.eclipse.builder.mdeforgeNature";
			    description.setNatureIds(newNatures);
			    project.setDescription(description, null);
			}
		}
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#deconfigure()
	 */
	public void deconfigure() throws CoreException {
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if(firstElement instanceof IAdaptable){
				IProject project = (IProject)((IAdaptable) firstElement).getAdapter(IProject.class);
				IProjectDescription description = project.getDescription();
				String[] natures = description.getNatureIds();
			    String[] newNatures = new String[natures.length - 1];
			    System.arraycopy(natures, 0, newNatures, 0, natures.length-1);//non va bene!
			    description.setNatureIds(newNatures);
			    project.setDescription(description, null);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#getProject()
	 */
	public IProject getProject() {
		return project;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject)
	 */
	public void setProject(IProject project) {
		this.project = project;
	}

}
