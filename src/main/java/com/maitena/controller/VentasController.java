package com.maitena.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maitena.model.Ticket;
import com.maitena.model.TicketProducto;
import com.maitena.repository.TicketProductoRepository;
import com.maitena.repository.TicketRepository;

@Controller
public class VentasController {

	@Autowired
	TicketRepository ticketRep;
	
	@Autowired
	TicketProductoRepository ticketProductoRep;
	
	@RequestMapping("/verTicket/{id}")
	public String verTicket(@PathVariable Integer id, Model model) {
		
	    Optional<Ticket> ticketOptional = ticketRep.findById(id);

	    if (ticketOptional.isPresent()) {
	        Ticket ticket = ticketOptional.get();
	        List<TicketProducto> listaProductosTicket = ticketProductoRep.obtenerProductosPorIdTicket(id);
	        
	        double totalTicket = listaProductosTicket.stream()
	                .mapToDouble(ticketProducto -> ticketProducto.getCantidad() * ticketProducto.getProducto().getPrecio())
	                .sum();
	        
	        
	        model.addAttribute("atr_ticket", ticket);
	        model.addAttribute("atr_producto_ticket", listaProductosTicket);
	        model.addAttribute("atr_total_ticket", totalTicket);

	        
	    }

	    return "ver_ticket";
	}
}
