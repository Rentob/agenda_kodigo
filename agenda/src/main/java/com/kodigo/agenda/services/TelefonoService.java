package com.kodigo.agenda.services;

import java.util.List;

import com.kodigo.agenda.entities.ContactoTelefono;

public interface TelefonoService {

	ContactoTelefono save(ContactoTelefono telefono);
	
	List<ContactoTelefono> saveAll(List<ContactoTelefono> telefonos);

	void deleteTelefono(Long id);

	List<ContactoTelefono> listTelefonosById(Long id);
}
