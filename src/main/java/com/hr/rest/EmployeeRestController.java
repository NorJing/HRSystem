package com.hr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hr.model.*;
import com.hr.service.EmployeeService;
@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService service;

//	private String getLoggedInUserName() {
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails){
//			return ((UserDetails) principal).getUsername();
//		}
//		return principal.toString();
//	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> listAllEmploees() {
		List<Employee> users = service.retrieveAllEmployees();
		return users;
	}

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee retrieveEmployee(@PathVariable("id") int id) {
		return service.retriveEmployeeById(id);
	}
}