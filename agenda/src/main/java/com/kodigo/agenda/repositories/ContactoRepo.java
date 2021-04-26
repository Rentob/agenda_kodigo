package com.kodigo.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigo.agenda.entities.Contacto;

@Repository
public interface ContactoRepo extends JpaRepository<Contacto, Long>{

}
