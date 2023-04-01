package com.spring_dep_inj;

public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Daily practice 30 mins in batting";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getRandomFortune();
	}
	
	
	
	
}
