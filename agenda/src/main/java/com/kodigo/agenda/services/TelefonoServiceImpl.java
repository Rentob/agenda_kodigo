package com.kodigo.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.ContactoTelefono;
import com.kodigo.agenda.repositories.ContactoRepo;
import com.kodigo.agenda.repositories.TelefonoRepo;


@Service
public class TelefonoServiceImpl implements TelefonoService{
	
	@Autowired
	private TelefonoRepo repo;
	@Autowired
	private ContactoRepo contactoRepo;
	@Override
	public ContactoTelefono save(ContactoTelefono telefono) {
		return repo.saveAndFlush(telefono);
	}

	@Override
	public void deleteTelefono(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<ContactoTelefono> listTelefonosById(Long id) {
		return contactoRepo.getOne(id).getTelefonos();
	}

	@Override
	public List<ContactoTelefono> saveAll(List<ContactoTelefono> telefonos) {
		return repo.saveAll(telefonos);
	}


}
