package com.hr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.model.User;
import com.hr.service.UserService;;

@Controller
public class UserController {

	@Autowired
	private UserService userservice;
	
	@ModelAttribute("user")
	public User createUser(){
		return new User();
	}
	
	@RequestMapping(value="list-users", method=RequestMethod.GET)
	public String listUsers(ModelMap model){
		model.addAttribute("users", userservice.listUsers());
		return "list-users";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegister(){
		System.out.println("in showRegister");
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user, BindingResult result){
		System.out.println("username=" + user.getName() + ",email=" + user.getEmail() + ",password=" + user.getPassword());
		if(result.hasErrors()){
			return "register";
		}
		userservice.addUser(user);
		return "redirect:/list-users";
	}
}
