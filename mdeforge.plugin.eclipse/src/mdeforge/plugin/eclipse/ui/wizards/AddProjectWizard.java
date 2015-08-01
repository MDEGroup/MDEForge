package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.ui.wizards.pages.DetailsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchMMPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchProjectsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.UsersPage;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class AddProjectWizard extends Wizard{

	private Shell shell;
	private UsersPage up;
	private DetailsPage dp;
	private IProject file;
	
	public AddProjectWizard(IProject file, Shell shell){
		super();
		setNeedsProgressMonitor(true);
		this.shell = shell;
		this.file = file;
	}

	@Override
	public String getWindowTitle(){
		return "Upload Project";
	}
	
	@Override
	public void addPages(){
		dp = new DetailsPage(file.getFullPath().lastSegment());
		up = new UsersPage();
		addPage(dp);
		addPage(up);
	}
	
	@Override
	public boolean performFinish() {
		System.out.println("Dettagli progetto: "+dp.getName()+";"+dp.getDescription()+";publico = "+dp.getPublic());
		System.out.println("Condiviso con: "+up.getSelectedUsers()[0]);
		boolean b = true;/*funzione da service controller per aggiungere il progetto e tutti i suoi artifact al forge*/
		return b;
	}
}
