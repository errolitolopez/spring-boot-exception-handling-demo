package com.example.springbootexceptionhandlingdemo.user;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.springbootexceptionhandlingdemo.exception.EmailAlreadExistingException;
import com.example.springbootexceptionhandlingdemo.exception.UserNotFoundException;
import com.example.springbootexceptionhandlingdemo.exception.UsernameAlreadyExistingException;

@Service
public class UserService {

	public void createUser(User user) {
		  boolean anyMatchUsername = getAll()
				  .stream()
				  .anyMatch(selectUser -> selectUser.getUsername().equals(user.getUsername()));

		  boolean anyMatchEmail = getAll()
				  .stream()
				  .anyMatch(selectUser -> selectUser.getEmail().equals(user.getEmail()));

		  if (anyMatchUsername) {
			  throw new UsernameAlreadyExistingException(
					  String.format("Username %s already existing", user.getUsername())
			);
		  }

		  if (anyMatchEmail) {
			  throw new EmailAlreadExistingException(
					  String.format("Email %s already existing", user.getEmail())
			);
		  }

		  System.out.println("Created!");
	}

	public List<User> getUsers() {
		return getAll();
	}

	public User getUserById(Integer userId) {
		Optional<User> user = getById(userId);

		if (user.isPresent()) {
			return user.get();
		}

		throw new UserNotFoundException(String.format("User not found with id: %s", userId));

	}

	public void deleteUser(Integer userId) {
		Optional<User> user = getById(userId);
		if (user.isPresent()) {
			System.out.println("Deleted!");
			return;
		}

		throw new UserNotFoundException(String.format("Unable to delete, user not found with id: %s", userId));
	}

	public void updateUser(User user, Integer userId) {
		Optional<User> selectUser = getById(userId);
		if (selectUser.isPresent()) {
			System.out.println("Updated!");
			return;
		}

		throw new UserNotFoundException(String.format("User not found with id: %s", userId));
	}

	private static List<User> getAll() {
		return Arrays.asList(
				new User(1, "jamesbond", "password", "jamesbond@email.com", "james", "bond"),
				new User(2, "johnmcclane", "12345", "johnmcclane@email.com", "john", "mcclane"),
				new User(3, "bryanmills", "12345", "bryanmills@email.com", "bryan", "mills")
		);
	}

	private static Optional<User> getById(Integer userId) {
		List<User> users =  getAll().stream()
				.filter(user -> user.getUserId().equals(userId))
				.collect(Collectors.toList());
		return users.stream().findFirst();
	}
}
