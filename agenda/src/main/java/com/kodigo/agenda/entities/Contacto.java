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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTOS")
public class Contacto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_CONTACTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContacto;
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoContacto")
    private TipoContacto tipoContacto;
	
	@OneToMany(mappedBy = "contacto", fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
	private List<ContactoTelefono> telefonos;
	
	@OneToMany(mappedBy = "contacto", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ContactoCorreo> correos;
	
	@OneToMany(mappedBy = "contacto", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private List<ContactoDireccion> direcciones;

	public Long getId() {
		return idContacto;
	}

	public void setId(Long id) {
		this.idContacto = id;
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

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public List<ContactoTelefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<ContactoTelefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<ContactoCorreo> getCorreos() {
		return correos;
	}

	public void setCorreos(List<ContactoCorreo> correos) {
		this.correos = correos;
	}

	public List<ContactoDireccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<ContactoDireccion> direcciones) {
		this.direcciones = direcciones;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
