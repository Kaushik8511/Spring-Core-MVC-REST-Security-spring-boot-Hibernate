package com.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean 
		Coach coach = context.getBean("badCoach", Coach.class);
		
	    //call the methods
		
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		//close the context
		context.close();
	}

}
