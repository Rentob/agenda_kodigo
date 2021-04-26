package com.kodigo.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.ContactoCorreo;
import com.kodigo.agenda.repositories.ContactoRepo;
import com.kodigo.agenda.repositories.CorreoRepo;

@Service
public class CorreoServiceImpl implements CorreoService {

	@Autowired
	private CorreoRepo repo;
	@Autowired
	private ContactoRepo contactoRepo;

	@Override
	public ContactoCorreo save(ContactoCorreo correo) {
		return repo.saveAndFlush(correo);
	}

	@Override
	public List<ContactoCorreo> saveAll(List<ContactoCorreo> correos) {
		return repo.saveAll(correos);
	}

	@Override
	public void deleteCorreo(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<ContactoCorreo> listCorreosById(Long id) {
		return contactoRepo.getOne(id).getCorreos();
	}

}
