package com.resource.api.service.impl;

import java.util.List;
import java.util.Optional;

import com.resource.api.entity.User;

public interface IUserService {
	
	public List<User> findAll();
	
	public void saveUser(User user);
	
	public User login(String useremail, String userpassword);
	
	public User findById(Long userid);
	
}
