package org.mdeforge.common.spring.validation;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;

public class ValidationUtility {

	public static void rejectIfMaxLength(Errors errors, String fieldName, String errorMessage, String fieldValue, int maxlength) {
		if (fieldValue != null && fieldValue.length() > maxlength) {
			Object[] args = { maxlength };
			errors.rejectValue(fieldName, errorMessage, args, "");
		}
	}
	
	public static void isValidEmail(Errors errors, String fieldName, String errorMessage, String fieldValue){
		final Pattern rfc2822 = Pattern.compile(
		        "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$"
		);
		
		if (!rfc2822.matcher(fieldValue).matches()) {
			Object[] args = { fieldValue };
			errors.rejectValue(fieldName, errorMessage, args, "Invalid Email Format");
		}
		
		
	}
}
