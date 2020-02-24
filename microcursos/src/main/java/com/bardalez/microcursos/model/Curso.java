package com.bardalez.microcursos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "curso")
public class Curso {

    @Id
    private String codigo;
    private String nombre;
    private String institucion;
    private Integer capacidadAlumnos;
    private Double precio;
    private String descripcion;
    private String horario;
    @Transient
    private String port;


    public Curso() {}

    public Curso(String codigo, String nombre, String institucion, Integer capacidadAlumnos, Double precio, String descripcion) {
        super();
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setInstitucion(institucion);
        this.setCapacidadAlumnos(capacidadAlumnos);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Integer getCapacidadAlumnos() {
        return capacidadAlumnos;
    }

    public void setCapacidadAlumnos(Integer capacidadAlumnos) {
        this.capacidadAlumnos = capacidadAlumnos;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}








