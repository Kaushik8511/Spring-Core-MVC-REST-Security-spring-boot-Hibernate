package com.spring_dep_inj;

public class DeveloperCoach implements Coach{
	
	private FortuneService fortuneService;

	//costructor 
	public DeveloperCoach(FortuneService fortuneService) {
		System.out.println("Developer coach object is getting initialized");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 12 hrs daily practicing the code";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getRandomFortune();
	}

}
