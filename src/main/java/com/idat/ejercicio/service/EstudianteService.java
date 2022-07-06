package com.idat.ejercicio.service;

import java.util.List;

import com.idat.ejercicio.dto.EstudianteDTORequest;
import com.idat.ejercicio.dto.EstudianteDTOResponse;



public interface EstudianteService {
	void guardarEstudiante(EstudianteDTORequest estudiante);
	void actualizarEstudiante(EstudianteDTORequest estudiante);
	void eliminarEstudiante(Integer id);	
	List<EstudianteDTOResponse>listarEstudiante();
	EstudianteDTOResponse obtenerEstudianteId(Integer id);
}
