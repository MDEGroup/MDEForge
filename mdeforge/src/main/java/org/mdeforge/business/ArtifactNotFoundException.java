package org.mdeforge.business;

public class ArtifactNotFoundException extends BusinessException {

	public ArtifactNotFoundException(String errorCode, String errorMessage) {
		super(errorCode,errorMessage);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -5021663643696080011L;

}
