package com.bardalez.microcursos.controller;


import com.bardalez.microcursos.model.Curso;
import com.bardalez.microcursos.model.Producto;
import com.bardalez.microcursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private Environment env;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/healthCatalogo", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @GetMapping("/cursos")
    public List<Curso> getProductos()
    {
        List<Curso> productList = cursoRepository.findAll();
        return productList;
    }

    @GetMapping("/actualizarCatalogo/{codigo}/{capacidadAlumnos}")
    public String actualizarCatalogo(@PathVariable String codigo, @PathVariable Integer capacidadAlumnos)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(codigo));
        Update update = new Update();
        update.set("capacidadAlumnos", capacidadAlumnos);
        mongoTemplate.updateFirst(query, update, Curso.class);
        return "ok";
    }

    @GetMapping("/curso/{codigo}")
    public Optional<Curso> getProducto(@PathVariable String codigo)
    {
        Optional<Curso> prod = cursoRepository.findById(codigo);
        prod.get().setPort(env.getProperty("local.server.port"));
        return prod;
    }

    @PutMapping("/curso/{codigo}")
    public Optional<Curso> updateEmployee(@RequestBody Curso newProducto, @PathVariable String codigo)
    {
        Optional<Curso> optionalPro = cursoRepository.findById(codigo);
        if (optionalPro.isPresent()) {
            Curso prod = optionalPro.get();
            prod.setNombre(newProducto.getNombre());
            prod.setInstitucion(newProducto.getInstitucion());
            prod.setCapacidadAlumnos(newProducto.getCapacidadAlumnos());
            prod.setPrecio(newProducto.getPrecio());
            prod.setDescripcion(newProducto.getDescripcion());
            cursoRepository.save(prod);
        }
        return optionalPro;
    }

    @DeleteMapping(value = "/curso/{codigo}", produces = "application/json; charset=utf-8")
    public String deleteEmployee(@PathVariable String codigo) {
        Boolean result = cursoRepository.existsById(codigo);
        cursoRepository.deleteById(codigo);
        return "{ \"operacionExitosa\" : "+ (result ? "true" : "false") +" }";
    }

    @PostMapping("/curso")
    public Curso addEmployee(@RequestBody Curso newProducto)
    {
        Curso prod = new Curso(newProducto.getCodigo(), newProducto.getNombre(), newProducto.getInstitucion() , newProducto.getCapacidadAlumnos(), newProducto.getPrecio() ,newProducto.getDescripcion());
        cursoRepository.insert(prod);
        return prod;
    }
}
