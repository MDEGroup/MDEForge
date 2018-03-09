package org.mdeforge.business;

public class TransformationException extends RuntimeException {

	private static final long serialVersionUID = -2836217323379334954L;

	public TransformationException() {
		super();
	}

	public TransformationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransformationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransformationException(String message) {
		super(message);
	}

	public TransformationException(Throwable cause) {
		super(cause);
	}

}
