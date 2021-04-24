package com.example.webdev.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.webdev.model.User;
import com.example.webdev.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user) {
		service.saveMyUser(user);
		return "Hello " + user.getFirstname() + " " + user.getLastname() + " your registration is successful!";
	}
	
	@GetMapping("/all-users")
	public Iterable<User> showAllUsers(){
		return service.showAllUsers();
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	public Iterable<User> deleteUser(@PathVariable String username){
		return service.deleteUserByUsername(username);
	}
	
	@GetMapping("/search/{username}")
	public User searchUser(@PathVariable String username) {
		return service.findByUsername(username);
	}
	
}
