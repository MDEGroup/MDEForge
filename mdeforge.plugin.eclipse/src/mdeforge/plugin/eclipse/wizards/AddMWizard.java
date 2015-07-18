package mdeforge.plugin.eclipse.wizards;

import mdeforge.plugin.eclipse.control.Controller;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class AddMWizard extends Wizard {

	protected AddProgectsPage ap;
	protected AddMMPage amm;
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
		
		//ap = new AddProgectsPage(file);
		amm = new AddMMPage();
		
		addPage(amm);
		//addPage(ap);
		
	}
	@Override
	public boolean performFinish(){
		/*ALTRA FUNZIONE DA RICHIAMARE*/
		
		/*boolean b = Controller.AddEcoretoForge(ap.getPublic(),
				ap.getFile(),
				ap.getProject());
		if(!b){
			MessageDialog.openError(shell, "Operation failure", "The task failed to execute.\n"
					+ "Check the settings on\n"
					+ "Window -> Preferences -> MDEForge");
		}*/
		return true;
		
	}

}