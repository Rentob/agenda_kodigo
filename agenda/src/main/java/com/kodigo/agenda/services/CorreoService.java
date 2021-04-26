package com.kodigo.agenda.services;

import java.util.List;

import com.kodigo.agenda.entities.ContactoCorreo;
public interface CorreoService {

	ContactoCorreo save(ContactoCorreo correo);
	
	List<ContactoCorreo> saveAll(List<ContactoCorreo> correos);

	void deleteCorreo(Long id);

	List<ContactoCorreo> listCorreosById(Long id);
}
