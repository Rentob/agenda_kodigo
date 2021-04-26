package com.kodigo.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigo.agenda.entities.Cita;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Long>{

}
