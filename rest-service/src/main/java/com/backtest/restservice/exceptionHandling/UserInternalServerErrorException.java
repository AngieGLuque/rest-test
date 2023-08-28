package com.backtest.restservice.exceptionHandling;

//Clase específica para la excepción Internal Server Error
public class UserInternalServerErrorException extends RuntimeException{

	public UserInternalServerErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public UserInternalServerErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
