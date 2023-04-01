package com.spring_dep_inj;

public class CricketCoach implements Coach {

	public FortuneService fortuneService;
	
	//setter for which is also getting used in setter injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach setter method called");
		this.fortuneService = fortuneService;
	}

	//custom bean initialize method
	public void myCustomInit() {
		System.out.println("This is the initialization code for cricket coach");
	}
	
	//my custom destroy method
	public void myCustomDestroy() {
		System.out.println("My custom destroy method for cricket coach");
	}

	//creating daily methods for interface Coach
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice batting 30 mins and bowling 30 mins daily";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getRandomFortune();
	}

}
