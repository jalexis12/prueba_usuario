package com.ruiz.app.test.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name = "usuarios")
@Entity
public class Usuario {
	@Column(name ="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="CUST-SEQ1")
	@SequenceGenerator(sequenceName = "customer_seq1",allocationSize = 1, name = "CUST_SEQ1")
	private Long id;
	
	@Column (name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "edad")
	private Integer edad;
	@Column(name = "ciudad")
	private String ciudad;
	
	//gets y sets
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
}
