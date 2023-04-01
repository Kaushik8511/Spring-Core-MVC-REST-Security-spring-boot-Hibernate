package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * We can use any method to inject dependencies
 * we simply have to give @Atutowired
 * @author kaushik
 */

@Component
@Scope("prototype")
public class BadCoach implements Coach{
	
	@Autowired
	@Qualifier("anotherFortuneService")
	private FortuneService fortuneService;
	
	public BadCoach() {
		System.out.println("in the construction of bad coach");
	}
	
	
// We can you any method to inject dependency
//	@Autowired
//	public void anyMethod(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "You cant do anything";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

}
