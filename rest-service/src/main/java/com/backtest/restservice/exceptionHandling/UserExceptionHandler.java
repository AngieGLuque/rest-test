package com.backtest.restservice.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Handler de las excepciones, su función es mapear el mensaje y el código para mostrarlo al usuario en la respuesta

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
		UserException userException = new UserException(
				userNotFoundException.getMessage(),
				userNotFoundException.getCause(), 
				HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(userException, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {UserBadRequestException.class})
	public ResponseEntity<Object> handleUserBadRequestException(UserBadRequestException userBadRequestException) {
		UserException userException = new UserException(
				userBadRequestException.getMessage(),
				userBadRequestException.getCause(), 
				HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {UserInternalServerErrorException.class})
	public ResponseEntity<Object> handleUserInternalServerErrorException(UserInternalServerErrorException userInternalServerErrorException) {
		UserException userException = new UserException(
				userInternalServerErrorException.getMessage(),
				userInternalServerErrorException.getCause(), 
				HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<>(userException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
