package com.springapp.myapp.myapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String rootMapping() {
		return "Hello world!! No need of time";
	}
	
	//new endpoint for /workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "do run 5 km daily";
	}
}


