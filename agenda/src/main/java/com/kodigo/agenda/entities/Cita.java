package com.kodigo.agenda.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CITAS")
public class Cita implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CITA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;
	@Column(name = "DECRIPCION")
	private String descripcion;
	@Column(name = "FECHA")
	private Date fecha;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;
	public Long getIdCita() {
		return idCita;
	}
	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
