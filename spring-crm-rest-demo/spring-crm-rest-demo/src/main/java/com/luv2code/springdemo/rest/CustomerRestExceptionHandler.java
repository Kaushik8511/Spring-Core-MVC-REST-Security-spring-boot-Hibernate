package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	// write handler for customer not found
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResoponse> exceptionHandler(CustomerNotFoundException e) {

		CustomerErrorResoponse errorResoponse = new CustomerErrorResoponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResoponse>(errorResoponse, HttpStatus.NOT_FOUND);
	}

	//Exception for mismatching method args - BAD_REQUEST
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResoponse> exceptionHandler(MethodArgumentTypeMismatchException e) {
		CustomerErrorResoponse errorResoponse = new CustomerErrorResoponse(HttpStatus.BAD_REQUEST.value(),
				"Args are mismatching", System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResoponse>(errorResoponse, HttpStatus.BAD_REQUEST);
	}
	
	// write handler for generic (any exception)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResoponse> exceptionHandler(Exception e) {
		CustomerErrorResoponse errorResoponse = new CustomerErrorResoponse(HttpStatus.BAD_REQUEST.value(),
				e.getMessage(), System.currentTimeMillis());

		return new ResponseEntity<CustomerErrorResoponse>(errorResoponse, HttpStatus.BAD_REQUEST);
	}

}
