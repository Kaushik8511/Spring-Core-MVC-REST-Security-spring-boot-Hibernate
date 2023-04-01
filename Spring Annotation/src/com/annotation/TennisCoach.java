package com.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * setter annotation
 * @author kaushik
 *
 */

@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	private FortuneService fortuneService;
	
	@Autowired
	@Qualifier("anotherFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("fortuneService setted");
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice catching the ball on the table";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
}
