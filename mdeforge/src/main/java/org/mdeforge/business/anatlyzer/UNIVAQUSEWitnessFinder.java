package org.mdeforge.business.anatlyzer;

import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.atl.witness.UseWitnessFinder;

public class UNIVAQUSEWitnessFinder extends UseWitnessFinder {

	
	@Override
	protected void onUSEInternalError(Exception e) {
		e.printStackTrace();
	}

	@Override
	public String getTempDirectory() {
		return "/Users/juri/development/forgeDir/anatlyze/tmp/";
	}
	

	@Override
	public IWitnessFinder catchInternalErrors(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWitnessFinder setDebugMode(boolean b) {
		// TODO Auto-generated method stub
		return null;
	}

}
