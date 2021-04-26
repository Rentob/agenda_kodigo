package com.kodigo.agenda.controller;

import java.util.ArrayList;
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

import com.kodigo.agenda.dto.ContactoDTO;
import com.kodigo.agenda.entities.Contacto;
import com.kodigo.agenda.entities.ContactoCorreo;
import com.kodigo.agenda.entities.ContactoDireccion;
import com.kodigo.agenda.entities.ContactoTelefono;
import com.kodigo.agenda.entities.TipoContacto;
import com.kodigo.agenda.entities.TipoCorreo;
import com.kodigo.agenda.entities.TipoDireccion;
import com.kodigo.agenda.entities.TipoTelefono;
import com.kodigo.agenda.entities.Usuario;
import com.kodigo.agenda.services.ContactoService;
import com.kodigo.agenda.services.CorreoService;
import com.kodigo.agenda.services.DireccionService;
import com.kodigo.agenda.services.TelefonoService;
import com.kodigo.agenda.services.UsuarioService;
import com.kodigo.agenda.utilidades.Mensaje;

@RestController
public class ContactoController {

	@Autowired
	private ContactoService contactoService;

	@Autowired
	private TelefonoService telefonoService;

	@Autowired
	private CorreoService correoService;

	@Autowired
	private DireccionService direccionService;

	@Autowired
	private UsuarioService usuarioService;

	Mensaje mensaje = new Mensaje();

	@GetMapping("contactos/list/{id}")
	public ResponseEntity<Object> listContactos(@PathVariable Long id) {
		try {
			List<Contacto> contactos = usuarioService.getUserByID(id).getContactos();
			return new ResponseEntity<>(contactos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("contactos/guardar")
	public ResponseEntity<Object> guardarContacto(@RequestBody ContactoDTO contactoDTO) {

		Contacto contacto = new Contacto();
		Usuario usuario = new Usuario();
		usuario.setId(contactoDTO.getIdUsuario());
		TipoContacto tipoContacto = new TipoContacto();
		tipoContacto.setIdTipoContacto(contactoDTO.getIdTipoContacto());
		List<ContactoTelefono> listaTelefonos = new ArrayList<>();
		List<ContactoCorreo> listaCorreos = new ArrayList<>();
		List<ContactoDireccion> listaDirecciones = new ArrayList<>();
		contacto.setPrimerNombre(contactoDTO.getPrimerNombre());
		contacto.setSegundoNombre(contactoDTO.getSegundoNombre());
		contacto.setPrimerApellido(contactoDTO.getPrimerApellido());
		contacto.setSegundoApellido(contactoDTO.getSegundoApellido());
		contacto.setTipoContacto(tipoContacto);
		contacto.setUsuario(usuario);
		Contacto contactoCreado = contactoService.save(contacto);

		for (int i = 0; i < contactoDTO.getTelefonos().size(); i++) {
			ContactoTelefono contactoTelefono = new ContactoTelefono();
			TipoTelefono tipoTelefono = new TipoTelefono();
			tipoTelefono.setIdTipoTelefono(contactoDTO.getTelefonos().get(i).getIdTipoTelefono());
			contactoTelefono.setTipotelefono(tipoTelefono);
			contactoTelefono.setTelefono(contactoDTO.getTelefonos().get(i).getTelefono());
			contactoTelefono.setContacto(contactoCreado);
			listaTelefonos.add(contactoTelefono);
		}
		for (int i = 0; i < contactoDTO.getCorreos().size(); i++) {
			ContactoCorreo contactoCorreo = new ContactoCorreo();
			TipoCorreo tipoCorreo = new TipoCorreo();
			tipoCorreo.setIdTipoCorreo(contactoDTO.getCorreos().get(i).getIdTipoCorreo());
			contactoCorreo.setTipoCorreo(tipoCorreo);
			contactoCorreo.setCorreo(contactoDTO.getCorreos().get(i).getCorreo());
			contactoCorreo.setContacto(contactoCreado);
			listaCorreos.add(contactoCorreo);
		}
		for (int i = 0; i < contactoDTO.getDirecciones().size(); i++) {
			ContactoDireccion contactoDireccion = new ContactoDireccion();
			TipoDireccion tipoDireccion = new TipoDireccion();
			tipoDireccion.setIdTipoDireccion(contactoDTO.getDirecciones().get(i).getIdTipoDireccion());
			contactoDireccion.setTipoDireccion(tipoDireccion);
			contactoDireccion.setDireccion(contactoDTO.getDirecciones().get(i).getDireccion());
			contactoDireccion.setContacto(contactoCreado);
			listaDirecciones.add(contactoDireccion);
		}
		telefonoService.saveAll(listaTelefonos);
		correoService.saveAll(listaCorreos);
		direccionService.saveAll(listaDirecciones);
		mensaje.setMensaje("Contacto creado con éxito!!");
		mensaje.setObject(contactoDTO);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);

	}

	@DeleteMapping("contactos/delete/{id}")
	public ResponseEntity<Object> deleteContacto(@PathVariable Long id) {
		try {
			contactoService.deleteContacto(id);
			mensaje.setMensaje("Contacto borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("contactos/delete_telefono/{id}")
	public ResponseEntity<Object> deleteContactoTelefono(@PathVariable Long id) {
		try {
			telefonoService.deleteTelefono(id);
			mensaje.setMensaje("Teléfono borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("contactos/guardar_telefonos/{id}")
	public ResponseEntity<Object> guardarContactoTelefonos(@RequestBody ContactoDTO contactoDTO,
			@PathVariable Long id) {

		Contacto contacto = contactoService.getContactoByID(id);
		List<ContactoTelefono> listaTelefonos = new ArrayList<>();
		for (int i = 0; i < contactoDTO.getTelefonos().size(); i++) {
			ContactoTelefono contactoTelefono = new ContactoTelefono();
			TipoTelefono tipoTelefono = new TipoTelefono();
			tipoTelefono.setIdTipoTelefono(contactoDTO.getTelefonos().get(i).getIdTipoTelefono());
			contactoTelefono.setTipotelefono(tipoTelefono);
			contactoTelefono.setTelefono(contactoDTO.getTelefonos().get(i).getTelefono());
			contactoTelefono.setContacto(contacto);
			listaTelefonos.add(contactoTelefono);
		}

		telefonoService.saveAll(listaTelefonos);
		mensaje.setMensaje("Teléfono creado con éxito!!");
		mensaje.setObject(contactoDTO);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);

	}
	
	@DeleteMapping("contactos/delete_direccion/{id}")
	public ResponseEntity<Object> deleteContactoDireccion(@PathVariable Long id) {
		try {
			direccionService.deleteDireccion(id);
			mensaje.setMensaje("Dirección borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("contactos/guardar_direcciones/{id}")
	public ResponseEntity<Object> guardarContactoDirecciones(@RequestBody ContactoDTO contactoDTO,
			@PathVariable Long id) {

		Contacto contacto = contactoService.getContactoByID(id);
		List<ContactoDireccion> listaDirecciones = new ArrayList<>();
		for (int i = 0; i < contactoDTO.getDirecciones().size(); i++) {
			ContactoDireccion contactoDireccion = new ContactoDireccion();
			TipoDireccion tipoDireccion = new TipoDireccion();
			tipoDireccion.setIdTipoDireccion(contactoDTO.getDirecciones().get(i).getIdTipoDireccion());
			contactoDireccion.setTipoDireccion(tipoDireccion);
			contactoDireccion.setDireccion(contactoDTO.getDirecciones().get(i).getDireccion());
			contactoDireccion.setContacto(contacto);
			listaDirecciones.add(contactoDireccion);
		}
		direccionService.saveAll(listaDirecciones);
		mensaje.setMensaje("Teléfono creado con éxito!!");
		mensaje.setObject(contactoDTO);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);

	}
	
	@DeleteMapping("contactos/delete_correo/{id}")
	public ResponseEntity<Object> deleteContactoCorreo(@PathVariable Long id) {
		try {
			correoService.deleteCorreo(id);
			mensaje.setMensaje("Correo borrado con éxito!!");
			mensaje.setObject(id);
			return new ResponseEntity<>(mensaje, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("contactos/guardar_correos/{id}")
	public ResponseEntity<Object> guardarContactoCorreos(@RequestBody ContactoDTO contactoDTO,
			@PathVariable Long id) {

		Contacto contacto = contactoService.getContactoByID(id);
		
		List<ContactoCorreo> listaCorreos = new ArrayList<>();
		for (int i = 0; i < contactoDTO.getCorreos().size(); i++) {
			ContactoCorreo contactoCorreo = new ContactoCorreo();
			TipoCorreo tipoCorreo = new TipoCorreo();
			tipoCorreo.setIdTipoCorreo(contactoDTO.getCorreos().get(i).getIdTipoCorreo());
			contactoCorreo.setTipoCorreo(tipoCorreo);
			contactoCorreo.setCorreo(contactoDTO.getCorreos().get(i).getCorreo());
			contactoCorreo.setContacto(contacto);
			listaCorreos.add(contactoCorreo);
		}
		correoService.saveAll(listaCorreos);
		
		mensaje.setMensaje("Correo creado con éxito!!");
		mensaje.setObject(contactoDTO);
		return new ResponseEntity<>(mensaje, HttpStatus.CREATED);

	}

}
