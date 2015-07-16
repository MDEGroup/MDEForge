package mdeforge.plugin.eclipse.preferences;

import mdeforge.plugin.eclipse.Activator;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class WorkbenchPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public WorkbenchPreferencePage() {
		super(GRID);
	}

	public WorkbenchPreferencePage(int style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

	public WorkbenchPreferencePage(String title, int style) {
		super(title, style);
		// TODO Auto-generated constructor stub
	}

	public WorkbenchPreferencePage(String title, ImageDescriptor image,
			int style) {
		super(title, image, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	    setDescription("MDEForge settings");

	}

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor("user","USERNAME",getFieldEditorParent()));
		addField(new StringFieldEditor("pass","PASSWORD",getFieldEditorParent()));

	}

}
