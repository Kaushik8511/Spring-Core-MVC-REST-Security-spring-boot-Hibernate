package com.aop.main.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution(* com.aop.main.dao.*.*(..))")
	public void allMethodsInPackage() {}
	
	@Pointcut("execution(* com.aop.main.dao.*.get*())")
	public void getter() {}
	
	
	@Pointcut("execution(void com.aop.main.dao.*.set*(*))")
	public void setter() {}
	
	@Pointcut("allMethodsInPackage() && !getter() && !setter()")
	public void allMethodsInPackageExceptGettersAndSetters() {}
}
