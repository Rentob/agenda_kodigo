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
@Table(name = "TIPO_TELEFONO")
public class TipoTelefono implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_TIPO_TELEFONO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoTelefono;
	@Column(name = "TIPO_TELEFONO")
	private String tipoTelefono;
	@OneToOne(mappedBy = "tipoTelefono")
    private ContactoTelefono contactoTelefono;
	public Long getIdTipoTelefono() {
		return idTipoTelefono;
	}
	public void setIdTipoTelefono(Long idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	
	
}
