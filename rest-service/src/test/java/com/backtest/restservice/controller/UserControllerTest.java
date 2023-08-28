package com.backtest.restservice.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.backtest.restservice.controllers.UserController;
import com.backtest.restservice.modelo.*;
import com.backtest.restservice.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Clase para las pruebas unitarias
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@BeforeEach
	void setUp() {
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	//Simulación de un escenario correcto
	@Test
	void testGetUserDetails() throws Exception{
		this.mockMvc.perform(get("/user/C&23445322")).andDo(print()).andExpect(status().isOk());
	}
}
