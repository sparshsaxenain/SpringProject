package com.prodapt.projectAlpha.exceptions;

import org.springframework.stereotype.Component;

@Component
public class InvalidCredentialException extends Exception{
	private String message;

	public InvalidCredentialException(String message) {
		this.message = message;
	}

	public InvalidCredentialException() {
	}
	
}
