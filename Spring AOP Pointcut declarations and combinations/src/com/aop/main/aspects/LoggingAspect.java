package com.aop.main.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


//aspect is a java class that has a related advices
@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("execution(* com.aop.main.dao.*.*(..))")
	private void allMethodsInPackage() {}
	
	@Pointcut("execution(* com.aop.main.dao.*.get*())")
	private void getter() {}
	
	
	@Pointcut("execution(void com.aop.main.dao.*.set*(*))")
	private void setter() {}
	
	
	//@Before advice
	@Before("allMethodsInPackage() && !getter() && !setter()")
	public void addAccountAdvice() {
		System.out.println("\n========> before advice\n");
	}
	
}


//com.aop.main.aspects.LoggingAspect