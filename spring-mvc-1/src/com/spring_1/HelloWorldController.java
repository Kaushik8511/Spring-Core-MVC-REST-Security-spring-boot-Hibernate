package com.spring_1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	
	//create show form page
	@RequestMapping("/show-form")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	//method to process the form
	@RequestMapping("/process-form")
	public String processForm() {
		return "helloworld";
	}
	
	//controller to read form data and
	//data to the model
	//and reading data using @requestParam
	@RequestMapping("/process-form-2")
	public String convertAllCap(@RequestParam("studentName") String name, Model model) {
		
		//read the request parameter
//		String name = req.getParameter("studentName");
		
		//convert to all upper case
		name = name.toUpperCase();
		
		//create a message
		String message = "welcome again again " + name;
		
		//add message to model
		model.addAttribute("message", message);
		
		//return view name
		return "helloworld";
	}
	
}
