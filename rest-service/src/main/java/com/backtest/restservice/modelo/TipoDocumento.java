package com.backtest.restservice.modelo;

public enum TipoDocumento {
	C("Cedula"), //Cedula
	P("Pasaporte"); //Pasaporte

	private final String etiqueta;
	
	private TipoDocumento(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	//Funcion para verificar si el tipoDocumento ingresado existe
	public static boolean typeExists(String name) {
		boolean bo = false;
		for(TipoDocumento tipo: values()) {
			if(tipo.name().equalsIgnoreCase(name)) {
				bo = true;
				break;
			}
		}
		return bo;
	}
	
	//Funcion para encontrar el valor TipoDocumento ingresando un String
	public static TipoDocumento findByName(String name) {
		TipoDocumento resultado = null;
		for(TipoDocumento tipo: values()) {
			if(tipo.name().equalsIgnoreCase(name)) {
				resultado  = tipo;
				break;
			}
		}
		return resultado;
	}
	
	//toString() por defecto regresa el nombre (name) del enumerator,
	//con el override hacemos que toString() regrese el valor de la etiqueta
	@Override
	public String toString() {
		return this.etiqueta;
	}
}
