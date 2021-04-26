package com.kodigo.agenda.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodigo.agenda.dto.UsuarioDTO;
import com.kodigo.agenda.entities.Usuario;
import com.kodigo.agenda.services.UsuarioService;
import com.kodigo.agenda.utilidades.Mensaje;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	Mensaje mensaje= new Mensaje();

	@GetMapping("usuarios/list")
	public List<Usuario> listUsuarios() {
		return service.listUsuarios();
	}

	@DeleteMapping("usuarios/delete/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) {
		try {
			service.deleteUsuario(id);
			mensaje.setMensaje("Usuario borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("usuarios/guardar")
	public ResponseEntity<Object> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		try {
			Usuario usu = new Usuario();
			BeanUtils.copyProperties(usuarioDTO, usu);
			service.save(usu);
			mensaje.setMensaje("Usuario creado con éxito!!");
			mensaje.setObject(usuarioDTO);
			return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
