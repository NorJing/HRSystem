package com.hr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hr.service.EmployeeService;
import com.hr.model.Employee;
import com.hr.model.User;

@Controller
@SessionAttributes("name")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ModelAttribute("employee")
	public Employee contructEmployee(){
		return new Employee();
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
//	private String getLoggedInUserName(ModelMap model){
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails){
//			return ((UserDetails) principal).getUsername();
//		}
//		return principal.toString();
//	}
	
	@RequestMapping(value = "/list-employees", method = RequestMethod.GET)
	public String showEmployeesList(ModelMap model) {
		// String user = getLoggedInUserName(model);
		model.addAttribute("employees", service.retrieveAllEmployees());
		return "list-employees";
	}
	
	@RequestMapping(value = "/add-employee", method = RequestMethod.GET)
	public String showEmployeePage(ModelMap model){
		System.out.println("in showEmployeePage Get");
		model.addAttribute("employee", new Employee());
		return "employee";
	}
	
	@RequestMapping(value = "/add-employee", method = RequestMethod.POST)
	public String AddEmployeePage(ModelMap model, @Valid Employee employee, BindingResult result){
		System.out.println("in AddEmployeePage Post");
		if(result.hasErrors()){
			return "employee";
		}
		service.addEmployee(employee.getEmployeeId(), employee.getEmployeeName(), employee.getAge(), employee.getBusinessTitle(), 
				employee.getSalary(), employee.getEmployDate(), employee.getIsHired());
		model.clear();
		return "redirect:/list-employees";
	}
	
	@RequestMapping(value="/delete-employee", method=RequestMethod.GET)
	public String deleteEmployee(int id){
		service.deleteEmployee(id);
		return "redirect:/list-employees";
	}
	
	@RequestMapping(value = "/update-employee", method = RequestMethod.GET)
	public String showUpdateEmployeePage(ModelMap model, @RequestParam int id) {
		System.out.println("in showUpdateEmployeePage Get");
		System.out.println("id=" + service.retriveEmployeeById(id).getId());
		model.addAttribute("employee", service.retriveEmployeeById(id));
		return "employee";
	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	public String updateEmployee(ModelMap model, @Valid Employee employee, BindingResult result) {
		System.out.println("in showUpdateEmployeePage Post");
		if (result.hasErrors()){
			System.out.println("update employee Post has error");
			return "employee";
		}
		// todo.setUser(getLoggedInUserName(model)); //TODO:Remove Hardcoding Later
		service.updateEmployee(employee);
		model.clear();// to prevent request parameter "name" to be passed
		return "redirect:/list-employees";
	}

}