package com.springapp.myapp.myapp.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//inject custom properties
	
	@Value("${author.name}")
	private String name;
	
	@Value("${author.email}")
	private String email;
	
	@GetMapping("/")
	public String rootMapping() {
		return "Hello world!! No need of time";
	}
	
	//new endpoint for /workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "do run 5 km daily";
	}
	
	//author info
	@GetMapping("/author")
	public String getAuthorInfo() {
		return "Author name: " + name + " \nAuthor email: " + email;
	}
}


