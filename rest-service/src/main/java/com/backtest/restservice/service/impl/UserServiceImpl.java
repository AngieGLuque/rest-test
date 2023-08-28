package com.backtest.restservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.backtest.restservice.exceptionHandling.UserBadRequestException;
import com.backtest.restservice.exceptionHandling.UserInternalServerErrorException;
import com.backtest.restservice.exceptionHandling.UserNotFoundException;
import com.backtest.restservice.modelo.TipoDocumento;
import com.backtest.restservice.modelo.User;
import com.backtest.restservice.service.UserService;

//Capa de servicios de la API
//Los servicios interactúan con la capa de datos y con la capa del controlador
//para este ejemplo no se implementó una capa de datos
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logInfo = LoggerFactory.getLogger(UserServiceImpl.class);

	User user = new User();

	
	// En esta capa se harán las comprobaciones necesarias para verificar que los
	// datos ingresados son correctos
	// o arrojar una excepción en caso contrario
	@Override
	public User getUserDetails(String tipoDocumento, String numDocumento) {
		logInfo.info("Función Actual: getUserDetails en " + this.getClass().getName());
		
		if (tipoDocumento.equals("") || numDocumento.equals("")) {
			// Si alguno de los campos está vacío, arrojará error 500
			
			logInfo.warn("El tipo de documento y/o el numero de documento no fueron"+
			" ingresados, por favor verifique los datos ingresados e intente nuevamente");
			logInfo.warn("Lanzando excepción Internal Server Error. HTTP STATUS: 500");
			
			throw new UserInternalServerErrorException(
					"Debe ingresar un valor para el tipo de documento y el numero de documento");
		} else if (!TipoDocumento.typeExists(tipoDocumento)) {
			// si el tipo de documento ingresado no existe, arrojará error 400
			
			logInfo.warn("Tipo de documento no aceptado, por favor verifique los datos ingresados e intente nuevamente");
			logInfo.warn("Lanzando excepción Bad Request. HTTP STATUS: 400");
			
			throw new UserBadRequestException("El tipo de documento '" + tipoDocumento + "' no es un tipo aceptado");

		} else if (!tipoDocumento.equals("C") || !numDocumento.equals("23445322")) {
			// si el tipo de documento o el numero de documento no coinciden, arrojará error 404
			
			logInfo.warn("Usuario no encontrado, por favor verifique los datos ingresados e intente nuevamente");
			logInfo.warn("Lanzando excepción Not Found. HTTP STATUS: 404");
			
			throw new UserNotFoundException("El usuario identificado con numero de "
					+ TipoDocumento.findByName(tipoDocumento).toString() + " " + numDocumento + " no existe");
		} else {
			// Si todo es correcto, los datos del usuario dejarán de ser nulos y se retornará el objeto usuario
			
			logInfo.info("Los datos del usuario fueron hallados correctamente");
			logInfo.info("Lanzando respuesta OK. HTTP STATUS: 200");
		
			user = new User(TipoDocumento.C, "23445322", "Pepito", "Fulano", "Perez", "Mendez", "0123456789",
					"Calle imaginaria 123", "Bogotá");
		}
		return user;
	}

}
