package com.backtest.restservice.exceptionHandling;

//Clase específica para la excepción BadRequest
public class UserBadRequestException extends RuntimeException{

	public UserBadRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public UserBadRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
