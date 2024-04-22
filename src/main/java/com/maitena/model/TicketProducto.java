package com.maitena.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets_productos")
public class TicketProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@ManyToOne
	private Ticket ticket;
	
	@ManyToOne
	private Producto producto;

	public TicketProducto(int cantidad, Ticket ticket, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.ticket = ticket;
		this.producto = producto;
	}
	
	public TicketProducto() {
		super();
		this.id = 0;
		this.cantidad = 0;
		this.ticket = new Ticket();
		this.producto = new Producto();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "TicketProducto id= " + id + ", cantidad= " + cantidad  + ", producto= " + producto;
	}
	
	
}
