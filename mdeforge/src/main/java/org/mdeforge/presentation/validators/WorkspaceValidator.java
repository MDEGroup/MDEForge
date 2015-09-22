package org.mdeforge.presentation.validators;

import org.mdeforge.business.model.Workspace;
import org.mdeforge.common.spring.validation.ValidationUtility;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class WorkspaceValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Workspace.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Workspace workspace = (Workspace) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "errors.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "errors.required");
		ValidationUtility.rejectIfMaxLength(errors, "name", "errors.maxlength", workspace.getName(), 255);
		
	}

}
