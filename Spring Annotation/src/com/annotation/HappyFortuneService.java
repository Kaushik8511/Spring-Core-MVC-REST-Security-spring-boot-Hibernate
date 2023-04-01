package com.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HappyFortuneService implements FortuneService{
	
	public  HappyFortuneService() {
		System.out.println("HappyFortuneService is called");
	}
	
	@Override
	public String getFortune() {
		return "Things are not going good";
	}

}
