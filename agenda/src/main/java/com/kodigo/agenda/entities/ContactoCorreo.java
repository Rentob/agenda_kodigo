package com.kodigo.agenda.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTOS_CORREOS")
public class ContactoCorreo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CORREO_CONTACTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCorreoContacto;
	@Column(name = "CORREO")
	private String correo;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idContacto", nullable = false)
	private Contacto contacto;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoCorreo")
    private TipoCorreo tipo;
	
	public Long getIdCorreoContacto() {
		return idCorreoContacto;
	}
	public void setIdCorreoContacto(Long idCorreoContacto) {
		this.idCorreoContacto = idCorreoContacto;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public TipoCorreo getTipoCorreo() {
		return tipo;
	}
	public void setTipoCorreo(TipoCorreo tipoCorreo) {
		this.tipo = tipoCorreo;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	

}
