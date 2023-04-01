package com.aop.main.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String var1;
	
	
	public String getVar1() {
		System.out.println(getClass() + " calling getters methods");
		return var1;
	}

	public void setVar1(String var1) {
		System.out.println(getClass() + " calling setter methods");
		this.var1 = var1;
	}


	public void addAccount() {
		System.out.println(getClass() + " Adding an account");
	}
	
}
