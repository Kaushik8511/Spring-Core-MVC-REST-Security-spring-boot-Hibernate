package com.spring_1;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//all the requests coming will go through this method as we have added InitBinder annotation
	//It will trim all the data of type string
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true); //true => empty to null?
		dataBinder.registerCustomEditor(String.class, editor);
	}
	
	@RequestMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute(new Customer());
		
		return "customer-form";
	}
	
	
	@RequestMapping("/process-form")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		
		System.out.println("\n\n\n\n\n\n");
		System.out.println("Binding result: " + bindingResult);
		System.out.println("\n\n\n\n\n\n");
		
		
		if(bindingResult.hasErrors()) {
			return "customer-form";
		}
		
		return "customer-confirmation";
	}
	
}
