package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.control.ServiceController;
import mdeforge.plugin.eclipse.ui.wizards.pages.DetailsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchMMPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchProjectsPage;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class AddMWizard extends Wizard {

	protected SearchProjectsPage ap;
	protected SearchMMPage amm;
	protected DetailsPage dp;
	private IFile file;
	private Shell shell;
	
	
	public AddMWizard(IFile file, Shell shell){
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
		amm = new SearchMMPage();
		ap = new SearchProjectsPage();
		
		
		addPage(amm);
		addPage(dp);
		addPage(ap);
		
	}
	@Override
	public boolean performFinish(){
		String ws_path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
		String id = "";
		for(String s : amm.getSelectedMM()){
			if(s != null){
				id = s;
				break;
			}
		}
		boolean b = true;//ServiceController.addModelToForge(dp.getPublic(),dp.getName(),dp.getDescription(), ws_path + file.getFullPath().toString(),
				//id);
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}
		return true;
		
	}

}