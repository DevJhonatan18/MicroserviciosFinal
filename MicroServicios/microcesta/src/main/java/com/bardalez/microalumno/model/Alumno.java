package com.bardalez.microalumno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "alumnoinscripcion")
public class Alumno {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer id;
	
	 @Column(name = "usario")
	 private String username;
	 
	 @Column(name = "alumno")
	 private String nombreAlumno;
	 
	 @Column(name = "dni")
	 private String dni;
	 
	 @Column(name = "pre_curso")
	 private Double precioporCurso;
	 
	 @Column(name = "unidades")
	 private Integer unidades;
	 
	 @Column(name = "prec_tot")
	 private Double precioTotal;
 
	public Alumno(){}

	public Alumno(String username,  String nombreAlumno , String dni , Double precioporCurso , int unidades ,
				     Double precioTotal     ) {
		super();
		this.setUsername(username);
		this.setNombreAlumno(nombreAlumno);
		this.setDni(dni);
		this.setPrecioporCurso(precioporCurso);
		this.setUnidades(unidades);
		this.setPrecioTotal(precioTotal);
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getPrecioporCurso() {
		return precioporCurso;
	}

	public void setPrecioporCurso(Double precioporCurso) {
		this.precioporCurso = precioporCurso;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
}
