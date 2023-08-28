package com.backtest.restservice.modelo;


//Modelo de datos del usuario
//El tipo documento es un enumerator para asegurar que solo puedan ingresarse los tipos aceptados
public class User{
	
	private TipoDocumento tipoDocumento;
	private String numDocumento;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefono;
	private String direccion;
	private String ciudad;
	
	public User() {
		tipoDocumento = null;
		numDocumento = "";
		primerNombre = "";
		segundoNombre= "";
		primerApellido = "";
		segundoApellido = "";
		telefono = "";
		direccion = "";
		ciudad = "";
	}

	public User(TipoDocumento tipoCedula, String cedula, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String telefono, String direccion, String ciudad) {
		this.tipoDocumento = tipoCedula;
		this.numDocumento = cedula;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}

	public String getTipoDocumento() {
		return tipoDocumento.name();
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setTipoDocumento(String tipo) {
		this.tipoDocumento = TipoDocumento.findByName(tipo);
	}

	public void setNumDocumento(String cedula) {
		this.numDocumento = cedula;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
