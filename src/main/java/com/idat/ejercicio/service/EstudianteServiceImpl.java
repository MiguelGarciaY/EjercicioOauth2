package com.idat.ejercicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ejercicio.dto.EstudianteDTORequest;
import com.idat.ejercicio.dto.EstudianteDTOResponse;
import com.idat.ejercicio.model.Estudiante;
import com.idat.ejercicio.repository.EstudianteRespository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
	@Autowired
	private EstudianteRespository repository;

	@Override
	public void guardarEstudiante(EstudianteDTORequest estudianteDTO) {
		Estudiante e=new Estudiante();		
		e.setNombre(estudianteDTO.getStudiante());
		repository.save(e);
		
	}

	@Override
	public void actualizarEstudiante(EstudianteDTORequest estudianteDTO) {
		Estudiante e=new Estudiante();
		e.setIdEstudiante(estudianteDTO.getIdentificador());
		e.setNombre(estudianteDTO.getStudiante());
		repository.saveAndFlush(e);
	}

	@Override
	public void eliminarEstudiante(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<EstudianteDTOResponse> listarEstudiante() {
		List<EstudianteDTOResponse> listar=new ArrayList<>();
		EstudianteDTOResponse dto=null;
		List<Estudiante> p=repository.findAll();
		
		for(Estudiante estudiante:p) {
			dto=new EstudianteDTOResponse();
			dto.setIdentificador(estudiante.getIdEstudiante());
			dto.setStudiante(estudiante.getNombre());

			listar.add(dto);
			
		}
		return listar;
	}

	@Override
	public EstudianteDTOResponse obtenerEstudianteId(Integer id) {
		Estudiante estudiante=repository.findById(id).orElse(null);
		EstudianteDTOResponse dto=null;
		dto=new EstudianteDTOResponse();
		dto.setIdentificador(estudiante.getIdEstudiante());
		dto.setStudiante(estudiante.getNombre());
		return dto;
	}
}
