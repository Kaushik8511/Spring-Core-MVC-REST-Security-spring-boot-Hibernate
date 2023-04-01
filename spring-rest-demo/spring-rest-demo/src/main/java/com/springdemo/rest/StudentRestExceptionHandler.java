package com.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handler -> can catch StudentNotFoundException
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> exceptionHandler(StudentNotFoundException e) {

		// create error response object
		StudentErrorResponse errorResponse = new StudentErrorResponse();

		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	// add an exception handler to catch any type of exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> exceptionHandler(Exception e) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();

		errorResponse.setMessage(e.getMessage());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
}
