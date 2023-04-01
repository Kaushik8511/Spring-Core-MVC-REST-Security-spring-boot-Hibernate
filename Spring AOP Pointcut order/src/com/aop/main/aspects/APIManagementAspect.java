package com.aop.main.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//aspect is a java class that has a related advices
@Aspect
@Component
@Order(-200)
public class APIManagementAspect {
		
	@Before("com.aop.main.aspects.AOPExpressions.allMethodsInPackageExceptGettersAndSetters()")
	public void apiManagement() {
		System.out.println("\n========> API management");
	}
}


//com.aop.main.aspects.LoggingAspect