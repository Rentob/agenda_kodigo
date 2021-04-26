package com.kodigo.agenda.services;


import com.kodigo.agenda.entities.Contacto;

public interface ContactoService {

	Contacto save(Contacto contacto);

	void deleteContacto(Long id);
	
	Contacto getContactoByID(Long id);
}
