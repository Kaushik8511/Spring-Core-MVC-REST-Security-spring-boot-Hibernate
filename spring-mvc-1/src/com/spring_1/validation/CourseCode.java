package com.spring_1.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define default value
	public String value() default "Kaushik";
	
	//define default error message
	public String message() default "must start with Kaushik";
	
	//define groups
	public Class<?>[] groups() default {};
	
	//define payload
	public Class<? extends Payload>[] payload() default {};

	
}
