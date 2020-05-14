package com.onDemand.carWash.userService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onDemand.carWash.userService.entity.User;
import com.onDemand.carWash.userService.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addNewUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

}
