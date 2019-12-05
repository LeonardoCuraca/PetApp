package com.resource.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.resource.api.entity.User;
import com.resource.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/users/{userid}")
	public User getUser(@PathVariable(value="userid") Long userid) {
		return userService.findById(userid);
	}
	
	@GetMapping("/login/{useremail}/{userpassword}")
	public User login(@PathVariable("useremail") String useremail, @PathVariable("userpassword") String userpassword) {
		return userService.login(useremail, userpassword);
	}
	
	@PostMapping("/usuarios")
	public User createUser(@RequestBody User user){
		userService.saveUser(user);
		return user;
	}
		
}