package com.bardalez.microcursos.repository;
/*
 * Aplicativo desarrollado para la clase de Java Expert
 * Autor: Cedric Bardalez (CJava Perú)
 * Version 1.0
 * www.cjavaperu.com
 */

import com.bardalez.microcursos.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CursoRepository extends MongoRepository<Curso, String> {

}
