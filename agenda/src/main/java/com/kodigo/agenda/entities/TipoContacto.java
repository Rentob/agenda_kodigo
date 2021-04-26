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
@Table(name = "TIPO_CONTACTO")
public class TipoContacto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_TIPO_CONTACTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoContacto;
	@Column(name = "TIPO_CONTACTO")
	private String tipoContacto;
	@OneToOne(mappedBy = "tipoContacto")
    private Contacto contacto;
	public Long getIdTipoContacto() {
		return idTipoContacto;
	}
	public void setIdTipoContacto(Long idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}
	public String getTipoContacto() {
		return tipoContacto;
	}
	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	

}
