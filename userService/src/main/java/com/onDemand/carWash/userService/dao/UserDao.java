package com.onDemand.carWash.userService.dao;

import java.util.List;

import com.onDemand.carWash.userService.entity.User;

public interface UserDao {

	User addNewUser(User user);
	
	User findByEmail(String email);
	
	List<User> getAllUsers();
	
}
