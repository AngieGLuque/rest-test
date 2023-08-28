package com.backtest.restservice.exceptionHandling;

//Clase específica para la excepción Not Found
public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
