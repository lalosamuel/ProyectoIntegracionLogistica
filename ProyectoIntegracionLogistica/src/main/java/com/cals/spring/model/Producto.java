package com.cals.spring.model;

public class Producto {

	private Integer id;
	private String nombre;
	private String descripcion;
	private String categoria;
	private String estado;
	
	
	public Producto() {
	}
	
	public Producto(Integer id, String nombre, String descripcion, String categoria, String estado) {
		this(nombre, descripcion, categoria, estado);
		this.id=id;
		
	}
		
	public Producto(String nombre, String descripcion, String categoria, String estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.estado = estado;
	}

	
	public String getNombre() {
		return nombre;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

		
	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", estado=" + estado + ", nombre=" + nombre
				+ ", categoria=" + categoria + "]";
	}


}
