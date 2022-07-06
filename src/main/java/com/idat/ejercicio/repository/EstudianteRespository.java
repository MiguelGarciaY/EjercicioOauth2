package com.idat.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ejercicio.model.Estudiante;
@Repository
public interface EstudianteRespository extends JpaRepository<Estudiante, Integer>{
}
