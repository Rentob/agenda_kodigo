package com.kodigo.agenda.services;

import java.util.List;

import com.kodigo.agenda.entities.Usuario;

public interface UsuarioService {
	List<Usuario> listUsuarios();

	Usuario save(Usuario usuario);

	void deleteUsuario(Long id);
	
	Usuario getUserByID(Long id);
}
