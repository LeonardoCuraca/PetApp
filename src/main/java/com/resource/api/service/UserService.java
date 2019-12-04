package com.resource.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IUserDao;
import com.resource.api.entity.User;
import com.resource.api.service.impl.IUserService;



@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {	
		return (List<User>) userDao.findAll();
		
	}

	@Override
	@Transactional(readOnly=true)
	public User findById(Long userid) {
		return userDao.findById(userid).orElse(null);
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);		
	}

	@Override
	public User login(String useremail, String userpassword) {
		return userDao.login(useremail, userpassword);
	}
	
}