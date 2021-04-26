package com.kodigo.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.Cita;
import com.kodigo.agenda.repositories.CitaRepo;


@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepo repo;

	@Override
	public List<Cita> listCitas() {
		return repo.findAll();
	}

	@Override
	public Cita save(Cita cita) {
		return repo.save(cita);
	}

	@Override
	public void deleteCita(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Cita getCitaByID(Long id) {
		return repo.getOne(id);
	}

}
