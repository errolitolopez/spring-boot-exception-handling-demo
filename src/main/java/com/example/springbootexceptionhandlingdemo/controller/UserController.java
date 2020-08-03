package com.example.springbootexceptionhandlingdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootexceptionhandlingdemo.user.User;
import com.example.springbootexceptionhandlingdemo.user.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}

	@GetMapping
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@PutMapping("/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable Integer userId) {
		userService.updateUser(user, userId);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userService.deleteUser(userId);
	}
}
