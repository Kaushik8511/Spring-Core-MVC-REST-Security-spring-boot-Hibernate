package com.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.main.dao.AccountDAO;

public class AfterThrowingMain {
	public static void main(String[] args) {
		
		//read the spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		///get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);		
		
		List<Account> accounts = null;
		
		try {
			accounts = accountDAO.findAccounts();
		}
		catch(Exception e) {
			System.out.println("Main program in catch block " + e.getMessage());
		}
		
		System.out.println("In main program");
		System.out.println(accounts);
		
		//close the context
		context.close();
		
	}
}
