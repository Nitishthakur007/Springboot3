package com.nitish.springboot.MVC_CRUD.Controller;


import com.nitish.springboot.MVC_CRUD.Model.Employee;
import com.nitish.springboot.MVC_CRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// get all employee from database
		List<Employee> theEmployees = employeeService.findAll();

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFromForAdd")
	public String showFormForAdd(Model theModel){

		// create model attribute to bind form data
		Employee theEmployee = new Employee();

		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}

	@GetMapping("/showFromForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") String theId, Model theModel){

		// get the employee from the service
		Employee theEmployee = employeeService.findById(theId);

		// set the employee in the model to prepopulate the form
		theModel.addAttribute("employee",theEmployee);
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
		// save the employee
		employeeService.save(theEmployee);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") String theId){
		// Delete the employee
		employeeService.deleteById(theId);

		// use a redirect to prevent duplicate submissions
		return "redirect:/employees/list";
	}

}









