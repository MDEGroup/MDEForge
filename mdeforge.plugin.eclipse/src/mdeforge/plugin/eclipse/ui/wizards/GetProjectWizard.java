package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.ui.wizards.pages.DetailsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchProjectsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.UsersPage;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

public class GetProjectWizard extends Wizard {

	private IFile file;
	private Shell shell;
	private SearchProjectsPage sp;
	
	public GetProjectWizard(IFile file, Shell shell){
		super();
		setNeedsProgressMonitor(true);
		this.shell = shell;
		this.file = file;
	}
	
	@Override
	public String getWindowTitle(){
		return "Import all the artifacts of a MDEForge project";
	}
	
	@Override
	public void addPages(){
		sp = new SearchProjectsPage();
		addPage(sp);
	}
	
	@Override
	public boolean performFinish() {
		boolean b = true;
		System.out.println(sp.getSelectedProjects()[0]);
		return b;
	}

}
