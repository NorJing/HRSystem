package com.hr.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import com.hr.model.*;

@Service
public class UserService {
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User("username1", "email1", "password1"));
	}
	
	public void addUser(User user){
		System.out.println("add username " + user.getName());
		users.add(user);
	}
	
	public List<User> listUsers(){
		return users;
	}
}
