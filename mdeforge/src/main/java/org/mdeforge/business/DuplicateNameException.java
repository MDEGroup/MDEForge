package org.mdeforge.business;

public class DuplicateNameException extends BusinessException {

	public DuplicateNameException(String errorCode, String errorMessage) {
		super(errorCode,errorMessage);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4091328064221457308L;

}
