package com.idat.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.ejercicio.dto.EstudianteDTORequest;
import com.idat.ejercicio.dto.EstudianteDTOResponse;
import com.idat.ejercicio.service.EstudianteService;


@Controller
@RequestMapping("/estudiante/v1")
public class EstudianteController {
	@Autowired
	private EstudianteService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<EstudianteDTOResponse>> listar() {
		return new ResponseEntity<List<EstudianteDTOResponse>>( service.listarEstudiante(),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody EstudianteDTORequest estudiante) {
		service.guardarEstudiante(estudiante);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		EstudianteDTOResponse p=service.obtenerEstudianteId(id);
		if(p != null) {
			service.eliminarEstudiante(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody EstudianteDTORequest estudiante) {
		EstudianteDTOResponse p=service.obtenerEstudianteId(estudiante.getIdentificador());
		
		if(p != null) {
			service.actualizarEstudiante(estudiante);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<EstudianteDTOResponse> obtenerID(@PathVariable Integer id) {
		EstudianteDTOResponse p=service.obtenerEstudianteId(id);
		
		if(p != null) {			
			return new ResponseEntity<EstudianteDTOResponse>(service.obtenerEstudianteId(id),HttpStatus.OK);
		}
		
		return new ResponseEntity<EstudianteDTOResponse>(HttpStatus.NOT_FOUND);
	}
}
