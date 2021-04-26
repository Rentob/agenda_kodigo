package com.kodigo.agenda.services;

import java.util.List;

import com.kodigo.agenda.entities.ContactoDireccion;
public interface DireccionService {

	ContactoDireccion save(ContactoDireccion direccion);
	
	List<ContactoDireccion> saveAll(List<ContactoDireccion> direcciones);

	void deleteDireccion(Long id);

	List<ContactoDireccion> listDireccionesById(Long id);
}
