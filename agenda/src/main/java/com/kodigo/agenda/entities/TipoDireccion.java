package com.kodigo.agenda.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DIRECCION")
public class TipoDireccion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_TIPO_DIRECCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoDireccion;
	@Column(name = "TIPO_DIRECCION")
	private String tipoDireccion;
	@OneToOne(mappedBy = "tipoDireccion")
    private ContactoDireccion contactoDireccion;
	public Long getIdTipoDireccion() {
		return idTipoDireccion;
	}
	public void setIdTipoDireccion(Long idTipoDireccion) {
		this.idTipoDireccion = idTipoDireccion;
	}
	public String getTipoDireccion() {
		return tipoDireccion;
	}
	public void setTipoDireccion(String tipoDireccion) {
		this.tipoDireccion = tipoDireccion;
	}
	
	
	
	
}
