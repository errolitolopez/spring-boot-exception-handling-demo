package com.example.springbootexceptionhandlingdemo.exception;

public class UsernameAlreadyExistingException extends ApiRequestException {

	public UsernameAlreadyExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlreadyExistingException(String message) {
		super(message);
	}
}
