package com.maitena.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tickets")
public class Ticket {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="hora")
	private String hora;
	
    @OneToMany(mappedBy = "ticket")
	private List<TicketProducto>productos;

	public Ticket(int id, String fecha, String hora, List<TicketProducto> productos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.productos = productos;
	}
	
	public Ticket() {
		super();
		this.id = 0;
		this.fecha = "";
		this.hora = "";
		this.productos = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<TicketProducto> getProductos() {
		return productos;
	}

	public void setProductos(List<TicketProducto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ",productos=" + productos + "]";
	}

    
    
    
	
}
