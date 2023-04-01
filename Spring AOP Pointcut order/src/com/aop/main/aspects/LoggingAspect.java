package com.aop.main.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//aspect is a java class that has a related advices
@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	//@Before advice
	@Before("com.aop.main.aspects.AOPExpressions.allMethodsInPackageExceptGettersAndSetters()")
	public void addAccountAdvice() {
		System.out.println("\n======>Account is being added");
	}
	
}


//com.aop.main.aspects.LoggingAspect