package com.spring_1;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.spring_1.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message = "It is a required field")
	@Size(min = 5, message = "please enter valid name")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "Can not be negative")
	@Max(value = 10, message = "Enter value less than 10")
	private Integer freePasses;
	
	@NotNull(message = "is required")
	@Pattern(regexp = "^[-zA-Z0-9]{6}", message = "Inavalid postal code")
	private String postalCode;
	
	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@NotNull(message = "is required")
	@CourseCode(value ="CSE", message = "It must start with CSE")
	private String courseCode;

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	
	
	
}
