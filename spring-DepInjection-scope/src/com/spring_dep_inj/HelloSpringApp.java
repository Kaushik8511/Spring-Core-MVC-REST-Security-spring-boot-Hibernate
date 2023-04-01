package com.spring_dep_inj;

import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Woo First spring application
 * so excited to learn further
 * @author Kaushik
 *
 *IoC => You can configure the configuration file as your need and you get the object based on that using factory method of bean
 */

public class HelloSpringApp {

	public static void main(String[] args) {
		
		//load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve bean from container
		//using constructor dependency injection for dependencies
		Coach coach = context.getBean("coach", Coach.class);
		
		//using setter dependency injection for dependencies
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);
		
		
		//call methods on the bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		
		
		
		//close the context
		context.close();
	}

}
