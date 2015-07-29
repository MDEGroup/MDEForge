package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.mdeforgecontrol.MDEForgeServiceController;
import mdeforge.plugin.eclipse.ui.wizards.pages.DetailsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchProjectsPage;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class AddEMMWizard extends Wizard {

	protected SearchProjectsPage ap;
	protected DetailsPage dp;
	private IFile file;
	private Shell shell;
	
	
	public AddEMMWizard(IFile file, Shell shell){
		super();
		setNeedsProgressMonitor(true);
		this.file = file;
		this.shell = shell;
	}
	
	
	@Override
	public String getWindowTitle(){
		return "Upload Local Artifact";
	}
	
	@Override
	public void addPages(){
		
		dp = new DetailsPage(file.getFullPath().lastSegment());
		ap = new SearchProjectsPage();
		/*
		if(file.getFileExtension().equals("ecore")){
			addPage(ap);
		}*/
		addPage(dp);
		addPage(ap);
		
	}
	@Override
	public boolean performFinish(){
		boolean b = true;//ServiceController.AddEcoretoForge(ap.getPublic(),
				//ap.getFile(),
				//ap.getProject());
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}
		return true;
		
	}

}
