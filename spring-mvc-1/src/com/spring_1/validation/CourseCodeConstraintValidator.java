package com.spring_1.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {
	
	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		// TODO Auto-generated method stub
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String validateString, ConstraintValidatorContext constraintValidatorContext) {
		// TODO Auto-generated method stub
		
		if(validateString != null) return validateString.startsWith(coursePrefix);
		
		return true;
	}

}
