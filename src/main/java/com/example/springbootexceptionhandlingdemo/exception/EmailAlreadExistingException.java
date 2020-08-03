package com.example.springbootexceptionhandlingdemo.exception;

public class EmailAlreadExistingException extends ApiRequestException {

	public EmailAlreadExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAlreadExistingException(String message) {
		super(message);
	}
}
