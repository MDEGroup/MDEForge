package mdeforge.plugin.eclipse.wizards;

import mdeforge.plugin.eclipse.control.ServiceController;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class GetEMMWizard extends Wizard {

	private String project;
	private Shell shell;
	private SearchMMPage smm;
	
	public GetEMMWizard(String project, Shell shell){
		super();
		setNeedsProgressMonitor(true);
		this.project = project;
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
		boolean b = ServiceController.downloadMetamodels(smm.getSelectedMM());
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}
		return true;
	}

}
