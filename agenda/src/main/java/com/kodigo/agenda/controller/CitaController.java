package com.kodigo.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodigo.agenda.dto.CitaDTO;
import com.kodigo.agenda.entities.Cita;
import com.kodigo.agenda.entities.Usuario;
import com.kodigo.agenda.services.CitaService;
import com.kodigo.agenda.services.UsuarioService;
import com.kodigo.agenda.utilidades.Mensaje;

@RestController
public class CitaController {
	
	@Autowired
	private CitaService citaService;

	@Autowired
	private UsuarioService usuarioService;
	
	Mensaje mensaje= new Mensaje();
	
	@GetMapping("cita/list/{id}")
	public ResponseEntity<Object> listCitas(@PathVariable Long id) {
		try {
			List<Cita> citas = usuarioService.getUserByID(id).getCitas();
			return new ResponseEntity<>(citas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("cita/guardar/{id}")
	public ResponseEntity<Object> guardarCita(@RequestBody CitaDTO citaDTO) {

		Usuario usuario = new Usuario();
		usuario.setId(citaDTO.getIdUsuario());
		Cita cita = new Cita();
		cita.setDescripcion(citaDTO.getDescripcion());
		cita.setFecha(citaDTO.getFecha());
		cita.setUsuario(usuario);
		citaService.save(cita);
		mensaje.setMensaje("Cita creado con éxito!!");
		mensaje.setObject(citaDTO);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);

	}
	
	@DeleteMapping("cita/delete/{id}")
	public ResponseEntity<Object> deleteContacto(@PathVariable Long id) {
		try {
			citaService.deleteCita(id);
			mensaje.setMensaje("Cita borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
