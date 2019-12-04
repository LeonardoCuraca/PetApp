package com.resource.api.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resource.api.entity.User;

@Repository
public interface IUserDao extends CrudRepository<User, Long>{
	
	@Query(value = "select * from users where useremail = \n-- #useremail\n and userpassword = \n-- #userpassword\n", nativeQuery = true)
	public User login(String useremail, String userpassword);
	
}
