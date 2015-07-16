package mdeforge.plugin.eclipse.actions;

import mdeforge.plugin.eclipse.Activator;
import mdeforge.plugin.eclipse.wizards.AddArtifactWizard;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.client.EcoreMetamodelService;

public class ActionAddArtifactMM implements IObjectActionDelegate {

	private Shell shell;
	private static EcoreMetamodelService emms;

	public ActionAddArtifactMM() {
		super();
	}

	@Override
	public void run(IAction action) {
		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		String username = preferenceStore.getString("user");
		String password = preferenceStore.getString("pass");
		try {
			emms = new EcoreMetamodelService("http://localhost:8080/mdeforge/",
					username, password);
		} catch (Exception e) {
			MessageDialog.openError(shell, "Connection Failure",
					"The connection failed, check the settings on\n"
							+ "Window -> Preferences -> MDEForge\n"
							+ "Current credential = " + username + " "
							+ password);
			e.printStackTrace();
			return;
		}
		/* retrieve selected file information */
		IWorkbenchWindow window = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (window != null) {
			IStructuredSelection selection = (IStructuredSelection) window
					.getSelectionService().getSelection();
			Object firstElement = selection.getFirstElement();
			if (firstElement instanceof IAdaptable) {
				IFile file = (IFile) ((IAdaptable) firstElement)
						.getAdapter(IFile.class);
				/* start the AddArtifactWizard */
				WizardDialog wizardDialog = new WizardDialog(shell,
						new AddArtifactWizard(file));
				if (wizardDialog.open() == Window.OK) {
					/*Action to add the artifact*/
					MessageDialog.openInformation(shell, "Add Artifact",
							"The request has been sent!");
				} else {
					System.out.println("Cancel pressed");
				}
			}
		}
		/*
		 * IWorkbenchWindow window = PlatformUI.getWorkbench()
		 * .getActiveWorkbenchWindow(); if (window != null) {
		 * IStructuredSelection selection = (IStructuredSelection) window
		 * .getSelectionService().getSelection(); Object firstElement =
		 * selection.getFirstElement(); if (firstElement instanceof IAdaptable)
		 * { IFile file = (IFile) ((IAdaptable) firstElement)
		 * .getAdapter(IFile.class); if
		 * (file.getFileExtension().equals("ecore")) { EcoreMetamodel metamodel
		 * = new EcoreMetamodel(); metamodel.setOpen(true); } else if
		 * (file.getFileExtension().equals("xmi")) { Model model = new Model();
		 * model.setOpen(true);
		 * 
		 * } } }
		 */

	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();

	}

}
