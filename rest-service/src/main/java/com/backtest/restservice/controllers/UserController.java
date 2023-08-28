package com.backtest.restservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backtest.restservice.responseHandling.ResponseHandler;
import com.backtest.restservice.service.UserService;


//Capa de controlador de la API
//El controlador interactua con el cliente y la capa de servicios
@RestController
@RequestMapping("/user")
public class UserController {
	
	private static final Logger logInfo = LoggerFactory.getLogger(UserController.class);
	
	UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	//Los datos de entrada son Tipo de documento y numero de documento
	@GetMapping("{tipoDocumento}&{numDocumento}")
	public ResponseEntity<Object> getUserDetails(@PathVariable("tipoDocumento") String tipoDocumento,@PathVariable("numDocumento") String numDocumento) {
		
		logInfo.info("Función Actual: getUserDetails en "+this.getClass().getName());
		logInfo.info("Datos de entrada: tipoDocumento = '"+tipoDocumento+"' , cedula = '"+numDocumento+"'");
		
		return ResponseHandler.responseBuilder("Los datos del usuario buscado se han encontrado correctamente", HttpStatus.OK, userService.getUserDetails(tipoDocumento, numDocumento));
		//Usamos la clase ResponseHandler para enviar un mensaje HTTP 200 personalizado
	}
}
