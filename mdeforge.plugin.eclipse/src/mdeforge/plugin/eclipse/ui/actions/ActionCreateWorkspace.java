package mdeforge.plugin.eclipse.ui.actions;

import mdeforge.plugin.eclipse.ui.wizards.AddMWizard;
import mdeforge.plugin.eclipse.ui.wizards.AddWSWizard;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class ActionCreateWorkspace implements IObjectActionDelegate {

	private Shell shell;
	
	public ActionCreateWorkspace() {
		super();
	}

	@Override
	public void run(IAction action) {
		WizardDialog wizardDialog = new WizardDialog(shell,
				new AddWSWizard());
		if (wizardDialog.open() == Window.OK) {
			MessageDialog.openInformation(shell, "Add Artifact",
					"The request has been sent!");
		} else {
			System.out.println("Cancel pressed");
		}
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// TODO Auto-generated method stub
		
	}


}
