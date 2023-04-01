package com.customer.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//set up looger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//set up pointcut declarations
	@Pointcut("execution(* com.customer.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.customer.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.customer.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void allCombinedPackages() {}
	
	//add @Before advice
	@Before("allCombinedPackages()")
	public void before(JoinPoint joinPoint) {
		//display the method advicing on
		String method = joinPoint.getSignature().toShortString();
		logger.info("======> in @Before: calling method: " + method);
		
		//display args
		Object[] args = joinPoint.getArgs();
		for(Object arg: args) logger.info("=======> argument: " + arg);
		
	}
	
	//add @afterReturning advice
	@AfterReturning(pointcut = "allCombinedPackages()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		//display method returning from
		String method = joinPoint.getSignature().toShortString();
		logger.info("=====> @AfterReturning from method: " + method);
		
		//display data returned
		logger.info("=======> result: " + result);
	}
	
}
