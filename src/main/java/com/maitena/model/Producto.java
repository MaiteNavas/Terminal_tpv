package com.maitena.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="precio")
	private Double precio;
	
	@Column(name="foto")
	private String foto;
	
	@Column(name="iva")
	private int iva;
	
	@ManyToOne
	private Categoria categoria;

	public Producto(int id, String nombre, Double precio, String foto, int iva, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.foto = foto;
		this.iva = iva;
		this.categoria = categoria;
	}
	
	public Producto() {
		super();
		this.id = 0;
		this.nombre = "";
		this.precio = 0.0;
		this.foto = "";
		this.iva = 0;
		this.categoria = new Categoria();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto id= " + id + ", nombre= " + nombre + ", precio= " + precio + ", foto= " + foto + ", iva= " + iva
				+ ", categoria= " + categoria;
	}

	
	
}
