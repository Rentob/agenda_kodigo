package com.kodigo.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigo.agenda.entities.ContactoCorreo;

@Repository
public interface CorreoRepo extends JpaRepository<ContactoCorreo, Long>{

}
