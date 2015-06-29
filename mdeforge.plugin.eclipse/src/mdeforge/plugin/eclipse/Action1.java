package mdeforge.plugin.eclipse;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.client.MDEForgeClient;

public class Action1 implements IObjectActionDelegate {

	private static MDEForgeClient mdefc;
	private final String url;
	private final String localurl = "http://127.0.0.1:8080/mdeforge";
	private final String serverurl = "http://www.mdeforge.org/";
	private final String username = "Admin";
	private final String passwd = "test123";
	private Shell shell;
	
	/**
	 * Constructor for Action1.
	 */
	public Action1() {
		super();
		url = serverurl;
	}
	
	
	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}
	
	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			mdefc = new MDEForgeClient(url,username,passwd);
		
			List<EcoreMetamodel> mm = mdefc.getEcoreMetamodels();
			String outmm = "";
			for(EcoreMetamodel el : mm){
				outmm += el.getName() + ";";
			}
			MessageDialog.openInformation(
					shell,
					"Popup",
					"Metamodelli importati:\n" + outmm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
	}

}
