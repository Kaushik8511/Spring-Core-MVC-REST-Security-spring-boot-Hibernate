package com.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AnotherFortuneService implements FortuneService {

	public AnotherFortuneService() {
		System.out.println("AnotherFortuneService is called");
	}
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Another fortune service";
	}

}
