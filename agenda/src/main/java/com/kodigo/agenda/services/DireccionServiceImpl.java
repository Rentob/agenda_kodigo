package com.kodigo.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.ContactoDireccion;
import com.kodigo.agenda.repositories.ContactoRepo;
import com.kodigo.agenda.repositories.DireccionRepo;


@Service
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	private ContactoRepo contactoRepo;
	@Autowired
	private DireccionRepo direccionRepo;


	@Override
	public ContactoDireccion save(ContactoDireccion direccion) {
		return direccionRepo.saveAndFlush(direccion);
	}

	@Override
	public List<ContactoDireccion> saveAll(List<ContactoDireccion> direcciones) {
		return direccionRepo.saveAll(direcciones);
	}

	@Override
	public void deleteDireccion(Long id) {
		direccionRepo.deleteById(id);
		
	}

	@Override
	public List<ContactoDireccion> listDireccionesById(Long id) {
		return contactoRepo.getOne(id).getDirecciones();
	}


}
