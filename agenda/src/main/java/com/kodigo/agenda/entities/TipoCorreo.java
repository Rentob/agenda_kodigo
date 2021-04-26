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
@Table(name = "TIPO_CORREO")
public class TipoCorreo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_TIPO_CORREO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoCorreo;
	@Column(name = "TIPO_CORREO")
	private String tipoCorreo;
	@OneToOne(mappedBy = "tipo")
    private ContactoCorreo contactoCorreo;
	public Long getIdTipoCorreo() {
		return idTipoCorreo;
	}
	public void setIdTipoCorreo(Long idTipoCorrreo) {
		this.idTipoCorreo = idTipoCorrreo;
	}
	public String getTipoCorreo() {
		return tipoCorreo;
	}
	public void setTipoCorreo(String tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
	}
	
	
	
}
