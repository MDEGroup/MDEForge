package org.mdeforge.business.anatlyzer;

import org.springframework.beans.factory.annotation.Value;

import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.atl.witness.UseWitnessFinder;

public class UNIVAQUSEWitnessFinder extends UseWitnessFinder {

	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	
	@Override
	protected void onUSEInternalError(Exception e) {
		e.printStackTrace();
	}

	@Override
	public String getTempDirectory() {
		return basePath + "anatlyze/tmp/";
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
