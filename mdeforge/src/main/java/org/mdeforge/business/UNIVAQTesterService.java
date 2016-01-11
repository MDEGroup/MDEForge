package org.mdeforge.business;

import org.mdeforge.business.model.ATLTransformation;

import transML.exceptions.transException;

public interface UNIVAQTesterService {
	void generateModel(ATLTransformation trafo) throws transException;
	public boolean executeTransformation (ATLTransformation transformation, boolean exhaustive);
}
