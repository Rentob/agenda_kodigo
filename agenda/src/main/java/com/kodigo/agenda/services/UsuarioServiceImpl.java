package com.kodigo.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodigo.agenda.entities.Usuario;
import com.kodigo.agenda.repositories.UsuarioRepo;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepo repo;

	@Override
	public List<Usuario> listUsuarios() {
		return repo.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}

	@Override
	public void deleteUsuario(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Usuario getUserByID(Long id) {
		return repo.getOne(id);
	}

}
