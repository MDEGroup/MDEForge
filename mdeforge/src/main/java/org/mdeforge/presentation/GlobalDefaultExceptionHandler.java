package org.mdeforge.presentation;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandeler() {
		System.out.println("ERROR");
		return null;
	}
}
