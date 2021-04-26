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
@Table(name = "CONTACTOS_DIRECCIONES")
public class ContactoDireccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_DIRECCION_CONTACTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDireccionContacto;
	@Column(name = "DIRECCION")
	private String direccion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idContacto", nullable = false)
	private Contacto contacto;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoDireccion")
    private TipoDireccion tipoDireccion;

	public Long getIdDireccionContacto() {
		return idDireccionContacto;
	}

	public void setIdDireccionContacto(Long idDireccionContacto) {
		this.idDireccionContacto = idDireccionContacto;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public TipoDireccion getTipoDireccion() {
		return tipoDireccion;
	}

	public void setTipoDireccion(TipoDireccion tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	
	

}
