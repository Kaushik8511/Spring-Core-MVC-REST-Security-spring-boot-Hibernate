package com.hibernate;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		String fn = "fn", ln = "ln", company = "TCS";
		
		
		//creating 10 students and adding it to database
		for(int i=0; i<10; i++) {
			CRUDEmployee.saveEmployee(new Employee(fn + i, ln + i, company));
		}

		//delete employee with odd id
		for(int i=0; i<10; i+=2) CRUDEmployee.deleteEmployee(CRUDEmployee.getEmployee(i+1));
		
		//Getting employee by company name
		List<Employee> employees = CRUDEmployee.getEmployeesByCompany("TCS");
		for(Employee employee: employees) System.out.println(employee);
		
		//deleting all
		CRUDEmployee.deleteAll();
		
		
	}

}
