package com.onDemand.carWash.userService.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onDemand.carWash.userService.dao.UserDao;
import com.onDemand.carWash.userService.entity.User;
import com.onDemand.carWash.userService.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserDao userDao;

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public User createNewUser(@RequestBody User user) {
		return userDao.addNewUser(user);
	}

	@GetMapping("/findEmail/{email}")
	public String findByEmail(@PathVariable String email) {
		User userInfo = userDao.findByEmail(email);
		if (Objects.nonNull(userInfo)) {
			return userInfo.toString();
		}
		throw new ResourceNotFoundException(email + "not found");
	}

	@GetMapping("/login/{email}/{password}")
	public String login(@PathVariable String email, @PathVariable String password) {
		User userInfo = userDao.findByEmail(email);
		if (Objects.nonNull(userInfo) && (password.equals(userInfo.getPassword()))) {
			return "Login Success";
		}
		throw new ResourceNotFoundException("Invalid Password");
	}
	
	@GetMapping("/getAll")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
}
