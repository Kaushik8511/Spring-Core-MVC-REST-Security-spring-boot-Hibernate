package com.aop.main.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


//aspect is a java class that has a related advices
@Aspect
@Component
@Order(-100)
public class CloudLoginAspect {
	
	@Before("com.aop.main.aspects.AOPExpressions.allMethodsInPackageExceptGettersAndSetters()")
	public void logToCloud() {
		System.out.println("\n========> Logging to cloud");
	}
}


//com.aop.main.aspects.LoggingAspect