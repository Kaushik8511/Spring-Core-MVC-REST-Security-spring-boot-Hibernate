package com.springdemo.entity;

public class Student {
	
	private String firstNane;
	private String lastNane;
	
	public Student() {}
	
	public Student(String firstNane, String lastNane) {
		super();
		this.firstNane = firstNane;
		this.lastNane = lastNane;
	}

	public String getFirstNane() {
		return firstNane;
	}

	public void setFirstNane(String firstNane) {
		this.firstNane = firstNane;
	}

	public String getLastNane() {
		return lastNane;
	}

	public void setLastNane(String lastNane) {
		this.lastNane = lastNane;
	}

	@Override
	public String toString() {
		return "Student [firstNane=" + firstNane + ", lastNane=" + lastNane + "]";
	}
	
	
	
}
