package com.kodigo.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodigo.agenda.entities.Usuario;
@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{

}
