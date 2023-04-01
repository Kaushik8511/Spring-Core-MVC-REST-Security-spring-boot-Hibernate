package com.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			//create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json from data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print out the results
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
