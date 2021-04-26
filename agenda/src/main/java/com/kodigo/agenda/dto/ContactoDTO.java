package com.kodigo.agenda.dto;

import java.util.List;

public class ContactoDTO {

	private Long idContacto;
	private Long idUsuario;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Long idTipoContacto;
	private List<TelefonoDTO> telefonos;
	private List<CorreoDTO> correos;
	private List<DireccionDTO> direcciones;
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Long getIdTipoContacto() {
		return idTipoContacto;
	}
	public void setIdTipoContacto(Long idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}
	public List<TelefonoDTO> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<TelefonoDTO> telefonos) {
		this.telefonos = telefonos;
	}
	public List<CorreoDTO> getCorreos() {
		return correos;
	}
	public void setCorreos(List<CorreoDTO> correos) {
		this.correos = correos;
	}
	public List<DireccionDTO> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<DireccionDTO> direcciones) {
		this.direcciones = direcciones;
	}
	public Long getIdContacto() {
		return idContacto;
	}
	public void setIdContacto(Long idContacto) {
		this.idContacto = idContacto;
	}
	
	

}
