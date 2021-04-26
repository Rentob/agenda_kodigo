package com.kodigo.agenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.Contacto;
import com.kodigo.agenda.repositories.ContactoRepo;

@Service
public class ContactoServiceImpl implements ContactoService {

	@Autowired
	private ContactoRepo repo;

	@Override
	public Contacto save(Contacto contacto) {
		return repo.saveAndFlush(contacto);
	}

	@Override
	public void deleteContacto(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Contacto getContactoByID(Long id) {
		return repo.getOne(id);
	}

}
