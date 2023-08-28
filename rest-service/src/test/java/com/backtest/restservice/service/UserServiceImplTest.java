package com.backtest.restservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.backtest.restservice.exceptionHandling.*;
import com.backtest.restservice.modelo.TipoDocumento;
import com.backtest.restservice.modelo.User;
import com.backtest.restservice.service.impl.UserServiceImpl;

public class UserServiceImplTest {
	
	private UserService userService;
	User user;
	
	@BeforeEach
	void setUp() {
		userService = new UserServiceImpl();
		user = new User(TipoDocumento.C, "23445322", "Pepito", "Fulano", "Perez", "Mendez", "0123456789",
				"Calle imaginaria 123", "Bogotá");
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	void testGetUserDetails() {

		assertThat(userService.getUserDetails("C", "23445322").getTipoDocumento()).isEqualTo(user.getTipoDocumento());
		assertThat(userService.getUserDetails("C", "23445322").getNumDocumento()).isEqualTo(user.getNumDocumento());
		assertThat(userService.getUserDetails("C", "23445322").getPrimerNombre()).isEqualTo(user.getPrimerNombre());
		assertThat(userService.getUserDetails("C", "23445322").getSegundoNombre()).isEqualTo(user.getSegundoNombre());
		assertThat(userService.getUserDetails("C", "23445322").getPrimerApellido()).isEqualTo(user.getPrimerApellido());
		assertThat(userService.getUserDetails("C", "23445322").getSegundoApellido()).isEqualTo(user.getSegundoApellido());
		assertThat(userService.getUserDetails("C", "23445322").getTelefono()).isEqualTo(user.getTelefono());
		assertThat(userService.getUserDetails("C", "23445322").getDireccion()).isEqualTo(user.getDireccion());
		assertThat(userService.getUserDetails("C", "23445322").getCiudad()).isEqualTo(user.getCiudad());
		
	}
	
	@Test
	void testNotFoundException() {
		Exception e = null;
		
		try {
			userService.getUserDetails("C", "12345");
		}
		catch(UserNotFoundException ex) {
			e = ex;
		}
		
		assertThat(e).isNotEqualTo(null);
	}
	
	@Test
	void testBadRequestException() {
		Exception e = null;
		
		try {
			userService.getUserDetails("A", "23445322");
		}
		catch(UserBadRequestException ex) {
			e = ex;
		}
		
		assertThat(e).isNotEqualTo(null);
	}
	
	@Test
	void testInternalServerErrorException() {
		Exception e = null;
		
		try {
			userService.getUserDetails("", "23445322");
		}
		catch(UserInternalServerErrorException ex) {
			e = ex;
		}
		
		assertThat(e).isNotEqualTo(null);
	}
}
