package com.aop.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.aop.main.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	
	@Override
	public String toString() {
		return "AccountDAO [name=" + name + ", serviceCode=" + serviceCode + "]";
	}

	//add account
	public void addAccount(Account accoun) {
		System.out.println(getClass() + " Adding an account\n");
	}
	
	//get the list of accounts
	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<Account>();
		
		//create some sample accounts
		Account account1 = new Account("Jeet", "23232dds");
		Account account2 = new Account("Vign", "LRD32dds");
		Account account3 = new Account("Avinash", "MAN232dds");
		
		//add them to list
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}

	
}
