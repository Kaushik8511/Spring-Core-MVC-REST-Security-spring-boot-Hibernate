package com.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.main.dao.AccountDAO;
import com.aop.main.dao.MembershipDAO;

public class Main {
	public static void main(String[] args) {
		
		//read the spring java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		///get the bean
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);		
		
		//call the biz method
		accountDAO.addAccount();
		accountDAO.getVar1();
		accountDAO.setVar1("abc");
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		membershipDAO.addAccount();
		
		//close the context
		context.close();
		
	}
}
