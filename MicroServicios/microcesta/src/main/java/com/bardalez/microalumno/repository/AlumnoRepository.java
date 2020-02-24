package com.bardalez.microalumno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bardalez.microalumno.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno,Integer>{

}
