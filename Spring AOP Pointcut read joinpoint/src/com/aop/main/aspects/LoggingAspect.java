package com.aop.main.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.main.Account;


//aspect is a java class that has a related advices
@Aspect
@Component
@Order(1)
public class LoggingAspect {
	
	//@Before advice
	@Before("com.aop.main.aspects.AOPExpressions.allMethodsInPackageExceptGettersAndSetters()")
	public void addAccountAdvice(JoinPoint joinPoint) {
		System.out.println("======>Account is being added");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("calling method signature => " + methodSignature);
		
		//display methods args
		Object[] args = joinPoint.getArgs();
		
		for(Object arg: args) {
			System.out.print(arg);
			
			if (arg instanceof Account) {
				Account account = (Account) arg;
				System.out.print("  " + account.getName());
				
			}
			
		}
		
		System.out.println();
		
	}
	
	//add a new advice for after returning
	@AfterReturning(
			pointcut = "execution(public * com.aop.main.dao.AccountDAO.findAccounts())",
			returning = "accounts"
			)
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> accounts) {
		
		//print out to which method we are advicing on
		String method = joinPoint.getSignature().toShortString();
		System.out.println("After returning from method =>>> " + method);
		
		//print out the accounts
		System.out.println("Accounts are: " + accounts);
		
		//post process the data
		if(!accounts.isEmpty()) {
			accounts.get(0).setName("Kaushik");
		}
	}
	
}


//com.aop.main.aspects.LoggingAspect