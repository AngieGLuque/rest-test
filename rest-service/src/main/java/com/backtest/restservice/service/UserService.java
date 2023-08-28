package com.backtest.restservice.service;

import com.backtest.restservice.modelo.User;

//En esta interfaz se agregarán todas las funciones que se desean implementar en  la capa de servicios
public interface UserService {
	//Para este ejemplo solo se implementará la función  de getUserDetails
	public User getUserDetails(String tipoDocumento, String numDocumento);
}
