package mdeforge.plugin.eclipse.actions;

import mdeforge.plugin.eclipse.wizards.GetEMMWizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class GetEcoreMM implements IObjectActionDelegate {

	private Shell shell;
	
	public GetEcoreMM() {
		super();
	}

	@Override
	public void run(IAction action) {
		/* retrieve selected file information */
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				IProject project = (IProject)((IAdaptable)firstElement);
				WizardDialog wizardDialog = new WizardDialog(shell,
						new GetEMMWizard(project.getFullPath().toString(),shell));
				if (wizardDialog.open() == Window.OK) {
					MessageDialog.openInformation(shell, "Add Artifact",
							"The request has been sent!");
				} else {
					System.out.println("Cancel pressed");
				}
			}
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
