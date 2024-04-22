package com.maitena.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maitena.model.Producto;
import com.maitena.model.Ticket;
import com.maitena.repository.ProductoRepository;
import com.maitena.repository.TicketRepository;

@Controller
public class MenuController {
	
	@Autowired
	ProductoRepository productoRep;
	
	@Autowired
	TicketRepository ticketRep;
	
	@RequestMapping("/tpv")
	public String menu_tpv(Model model) {
		
		return "redirect:/";
	}
	
	@RequestMapping("/ventas")
		public String menu_ventas(Model model) {
			
			List<Ticket> listaTickets= ticketRep.findAll();
			
			model.addAttribute("atr_lista_tickets", listaTickets);
			
		return "ventas";
	}
	
	@RequestMapping("/admin")
	public String menu_admin(Model model) {
		
		List<Producto> listaProductos= productoRep.findAll();
		
		model.addAttribute("atr_lista_productos", listaProductos);
		model.addAttribute("objeto_producto",new Producto());
		
		return "admin";
	}

	
}
