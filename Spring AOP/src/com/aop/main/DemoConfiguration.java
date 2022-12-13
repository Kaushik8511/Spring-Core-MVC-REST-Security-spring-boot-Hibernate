package com.aop.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.aop.main.dao.AccountDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aop")
public class DemoConfiguration {

	
	@Bean
	public AccountDAO getAccountDAO() {
		return new AccountDAO();
	}
	
}
