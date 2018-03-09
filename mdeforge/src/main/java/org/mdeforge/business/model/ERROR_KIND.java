package org.mdeforge.business.model;

public enum ERROR_KIND { 
	// execution errors
	EXECUTION_RAISES_EXCEPTION, EXECUTION_YIELDS_ILL_TARGET,
	// anatlyser errors
	ANATLYZER_DETECTED_ERROR, ANATLYZER_DOES_NOT_FINISH
}