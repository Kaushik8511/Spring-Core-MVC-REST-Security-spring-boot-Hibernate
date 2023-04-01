package com.spring_ioc;

public class MyApp {

	public static void main(String[] args) {
		
		//create the object
		Coach coach = new CricketCoach();
		
		//use the object
		System.out.println(coach.getDailyWorkout());
		
		coach = new BaseballCoach();
		System.out.println(coach.getDailyWorkout());
	}

}
