package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.mdeforgecontrol.MDEForgeServiceController;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchMMPage;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class GetEMMWizard extends Wizard {

	private Shell shell;
	private SearchMMPage smm;
	private IPath path;
	
	public GetEMMWizard(IPath path, Shell shell){
		super();
		setNeedsProgressMonitor(true);
		this.path = path;
		this.shell = shell;
	}
	
	@Override
	public String getWindowTitle(){
		return "Download Remote EcoreMetamodels";
	}
	
	@Override
	public void addPages(){
		smm = new SearchMMPage();
		addPage(smm);
		
	}
	
	@Override
	public boolean performFinish() {
		boolean b = MDEForgeServiceController.downloadMetamodels(path.toString(), smm.getSelectedMM());
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}
		return true;
	}

}
