package mdeforge.plugin.eclipse.ui.actions.services;

import mdeforge.plugin.eclipse.Activator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.mdeforge.client.EcoreMetamodelService;

public class ActionEcoreSimilarity implements IObjectActionDelegate {

	private Shell shell;
	private EcoreMetamodelService emms;
	
	public ActionEcoreSimilarity() {
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
		
		MessageDialog.openInformation(shell, "Ecore Similarity", "The functionality requires more server API");

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
