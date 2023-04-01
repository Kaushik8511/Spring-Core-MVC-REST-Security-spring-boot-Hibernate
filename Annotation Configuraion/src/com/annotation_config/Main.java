package com.annotation_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//load config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//fetch bean
		Coach coach = context.getBean("swimCoach", Coach.class);
		
		//use bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getFortune());
		
		//close the context
		context.close();
		
//		Coach coach = new SwimCoach(new HappyFortuneService());
//		System.out.println(coach.getDailyWorkout());
//		System.out.println(coach.getFortune());
		

	}

}
