package mdeforge.plugin.eclipse.views;



import mdeforge.plugin.eclipse.Activator;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.*;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class MDEForgePreferencesView extends ViewPart {

	private Label label1,label2;

	public void createPartControl(Composite parent) {
		IPreferenceStore preferenceStore = Activator.getDefault()
				.getPreferenceStore();
		String stringuser = preferenceStore.getString("user");
		String stringpassword = preferenceStore.getString("pass");

		label1 = new Label(parent, SWT.NONE);
		label2 = new Label(parent,SWT.NONE);
		label1.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
				false));
		label1.setText("user: "+stringuser);
		label2.setText("password: "+stringpassword);
		// add change listener to the preferences store so that we are notified
		// in case of changes
		Activator.getDefault().getPreferenceStore()
				.addPropertyChangeListener(new IPropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent event) {
						if(event.getProperty() == "user"){
							label1.setText(event.getProperty()+": "+event.getNewValue().toString());
						}
						else{
							label2.setText(event.getProperty()+": "+event.getNewValue().toString());
						}
					}
				});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
	}
}