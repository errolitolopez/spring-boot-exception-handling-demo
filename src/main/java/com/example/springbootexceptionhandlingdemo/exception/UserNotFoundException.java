package com.example.springbootexceptionhandlingdemo.exception;

public class UserNotFoundException extends ApiRequestException {

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
