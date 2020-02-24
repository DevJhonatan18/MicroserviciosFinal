package com.bardalez.microalumno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;




public class Curso {
    private String codigo;
    private String nombre;
    private String institucion;
    private Integer capacidadAlumnos;
    private Double precio;
    private String descripcion;
    private String horario;

    private String port;


    public Curso() {}

    public Curso(String codigo, String nombre, String institucion, Integer capacidadAlumnos, Double precio, String descripcion , String horario ) {
        super();
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setInstitucion(institucion);
        this.setCapacidadAlumnos(capacidadAlumnos);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
        this.setHorario(horario);
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








