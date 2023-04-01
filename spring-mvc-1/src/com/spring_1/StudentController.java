package com.spring_1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	//method to show our form
	@RequestMapping("/student-form")
	public String showForm(Model model) {
		
		//add student to model
		model.addAttribute("student", new Student());
		
		//return view student form
		return "student-form";
	}
	
	//to process form
	@RequestMapping("process-form")
	public String processForm(@ModelAttribute("student") Student student) {
		
		//log the data
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		System.out.println(student.getCountry());
		System.out.println(student.getFavoriteLanguage());
		
		
		
		return "student-confirmation";
	}
}
