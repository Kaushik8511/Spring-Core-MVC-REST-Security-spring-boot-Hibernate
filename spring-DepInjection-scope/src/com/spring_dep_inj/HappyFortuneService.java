package com.spring_dep_inj;

import java.util.Random;

public class HappyFortuneService implements FortuneService {
	
	private int isFortunate; 
	
	


	public void setIsFortunate(int isFortunate) {
		this.isFortunate = isFortunate;
	}


	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		if(isFortunate == 1) return "It's lucky day, You have started spring today!!!";
		return "You dont have enough preparation, focus buddy on the spring";
	}


	@Override
	public String getRandomFortune() {
		String[] fortunes = new String[3];
		fortunes[0] = "first random fortune";
		fortunes[1] = "second random fortune";
		fortunes[2] = "third random fortune";
		Random random = new Random();
		return fortunes[random.nextInt(3)];
	}

}
