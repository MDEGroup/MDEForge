package mdeforge.plugin.eclipse.wizards;

import mdeforge.plugin.eclipse.control.ServiceController;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class AddEMMWizard extends Wizard {

	protected AddProgectsPage ap;
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
		
		ap = new AddProgectsPage(file);
		
		if(file.getFileExtension().equals("ecore")){
			addPage(ap);
		}
		
	}
	@Override
	public boolean performFinish(){
		boolean b = ServiceController.AddEcoretoForge(ap.getPublic(),
				ap.getFile(),
				ap.getProject());
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}
		return true;
		
	}

}
