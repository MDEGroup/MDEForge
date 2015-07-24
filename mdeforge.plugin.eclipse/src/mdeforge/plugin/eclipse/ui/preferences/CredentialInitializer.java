package mdeforge.plugin.eclipse.ui.preferences;

import mdeforge.plugin.eclipse.Activator;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

public class CredentialInitializer extends AbstractPreferenceInitializer {

	public CredentialInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
	    store.setDefault("user", "your username at MDEForge");
	    store.setDefault("pass", "your password at MDEForge");

	}

}
