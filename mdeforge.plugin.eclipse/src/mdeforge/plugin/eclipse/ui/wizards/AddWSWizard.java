package mdeforge.plugin.eclipse.ui.wizards;

import mdeforge.plugin.eclipse.control.ServiceController;
import mdeforge.plugin.eclipse.ui.wizards.pages.DetailsPage;
import mdeforge.plugin.eclipse.ui.wizards.pages.SearchMMPage;

import org.eclipse.jface.wizard.Wizard;

public class AddWSWizard extends Wizard {

	private DetailsPage dp;
	
	public AddWSWizard(){
		super();
	}
	
	@Override
	public String getWindowTitle(){
		return "Create New Workspace";
	}
	
	@Override
	public void addPages(){
		
		//ap = new AddProgectsPage(file);
		dp = new DetailsPage("");
		addPage(dp);
		//addPage(ap);
		
	}
	
	@Override
	public boolean performFinish() {
		ServiceController.addWorkspaceToForge(dp.getName(), dp.getDescription());
		return false;
	}

}
