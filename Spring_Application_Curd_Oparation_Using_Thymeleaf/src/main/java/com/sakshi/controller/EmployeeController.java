package com.sakshi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sakshi.service.EmployeeService;
import com.sakshi.model.Employee;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	
	
	//  display list of employees...
	
	//@RequestMapping
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("listEmployess", employeeService.getAllEmployees());
		
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		
		// create model attribute to bind form data
		 Employee employee = new  Employee();
		model.addAttribute("employee", employee);
		
		return "new_employee";
	}
	
	
	

}
