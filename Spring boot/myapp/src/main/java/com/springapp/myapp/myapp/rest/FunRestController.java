package com.springapp.myapp.myapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@GetMapping("/")
	public String rootMapping() {
		return "Hello world!! time on server is " + LocalDateTime.now();
	}
}
