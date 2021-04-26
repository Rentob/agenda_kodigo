package com.kodigo.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigo.agenda.entities.ContactoDireccion;

@Repository
public interface DireccionRepo extends JpaRepository<ContactoDireccion, Long>{

}
