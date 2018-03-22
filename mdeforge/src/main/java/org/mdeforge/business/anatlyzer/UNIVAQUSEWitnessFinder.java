package org.mdeforge.business.anatlyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import anatlyzer.atl.witness.IWitnessFinder;
import anatlyzer.atl.witness.UseWitnessFinder;

public class UNIVAQUSEWitnessFinder extends UseWitnessFinder {

	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	Logger logger = LoggerFactory.getLogger(UNIVAQUSEWitnessFinder.class);

	@Override
	protected void onUSEInternalError(Exception e) {
		logger.error(e.getMessage() + e.getStackTrace());
	}

	@Override
	public String getTempDirectory() {
		return basePath + "anatlyzer/tmp/";
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
