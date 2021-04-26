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
@Table(name = "CONTACTOS_TELEFONOS")
public class ContactoTelefono implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID_TELEFONO_CONTACTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContactoTelefono;
	@Column(name = "TELEFONO")
	private String telefono;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idContacto", nullable = false)
	private Contacto contacto;
	
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idTipoTelefono")
    private TipoTelefono tipoTelefono;
	
	public Long getIdContactoTelefono() {
		return idContactoTelefono;
	}
	public void setIdContactoTelefono(Long idContactoTelefono) {
		this.idContactoTelefono = idContactoTelefono;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public TipoTelefono getTipotelefono() {
		return tipoTelefono;
	}
	public void setTipotelefono(TipoTelefono tipotelefono) {
		this.tipoTelefono = tipotelefono;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

}
