package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DeveloperCoach implements Coach {

	private FortuneService fortuneService;
	
	//Constructor injection using annotation
	@Autowired
	
	public DeveloperCoach(@Qualifier("anotherFortuneService") FortuneService fortuneService) {
		System.out.println("Developer also has a constructor");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "You must have to finish the spring framework in the next few days";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
