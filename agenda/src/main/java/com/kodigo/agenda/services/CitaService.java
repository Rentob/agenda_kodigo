package com.kodigo.agenda.services;

import java.util.List;

import com.kodigo.agenda.entities.Cita;

public interface CitaService {
	List<Cita> listCitas();

	Cita save(Cita cita);

	void deleteCita(Long id);
	
	Cita getCitaByID(Long id);
}
