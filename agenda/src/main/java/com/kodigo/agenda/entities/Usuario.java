package com.kodigo.agenda.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "PASSWORD")
	private String passWord;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Contacto> contactos;
	
	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<Cita> citas;
	
	public Long getId() {
		return idUsuario;
	}
	public void setId(Long id) {
		this.idUsuario = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public List<Contacto> getContactos() {
		return contactos;
	}
	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
	public List<Cita> getCitas() {
		return citas;
	}
	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	
}
