package com.maitena.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maitena.model.Producto;
import com.maitena.model.Ticket;
import com.maitena.model.TicketProducto;
import com.maitena.repository.ProductoRepository;
import com.maitena.repository.TicketProductoRepository;
import com.maitena.repository.TicketRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class TpvController {

	@Autowired
	ProductoRepository productoRep;
	
	@Autowired
	TicketRepository ticketRep;
	@Autowired
	TicketProductoRepository ticketProductoRep;
	
	@GetMapping("/agregrarProductoAlTicket/{id}")
	public String agregarProductoTicket(HttpSession session, @PathVariable int id, Model model) {
		
		String identificador = ""+id;
		
		if(session.getAttribute(identificador)!= null) {
			
			session.setAttribute(identificador, (int)session.getAttribute(identificador) +1);
			
		} else { 
			
			session.setAttribute(identificador, 1);
		}
		
		
		Enumeration<String> enumerado = session.getAttributeNames();
		
		List<String> listaDeAtributos = Collections.list(enumerado);

		for (String elemento : listaDeAtributos) {
			
			System.out.println(elemento);
			System.out.println(session.getAttribute(elemento));
			
		}

		
		model.addAttribute("atr_lista_productos", productoRep.findAll());

				
		if(!listaDeAtributos.isEmpty()) {

			
			List<Map.Entry<Producto, Integer>> listaReal = new ArrayList<>();

			for (String elemento : listaDeAtributos) {

				Producto p = productoRep.getById(Integer.parseInt(elemento));
				
				int cantidad = (int) session.getAttribute(elemento);

				listaReal.add(new SimpleEntry<>(p, cantidad));
			}

			model.addAttribute("atr_datos_en_sesion", listaReal);
			
		}
		
		return "redirect:/";
	}

	
	@SuppressWarnings("deprecation")
	@RequestMapping("/guardarTicket")
	public String guardarTicket(HttpSession session) {
		
		Ticket ticket = new Ticket();
		
		Date fechaCompleta = new Date();
		
		SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = fecha.format(fechaCompleta);

        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        String horaFormateada = hora.format(fechaCompleta);

        ticket.setFecha(fechaFormateada);
        ticket.setHora(horaFormateada);
        
        Ticket ticketGuardado = ticketRep.save(ticket);
        
        //int ticketId = ticketGuardado.getId();
        
        //Obtener de la sesion todos los objetos y las cantidades
        	//Obtenemos una lista de atributos con los keys de la sesion que son los id de los productos
		Enumeration<String> enumerado = session.getAttributeNames();
		List<String> listaDeAtributos = Collections.list(enumerado);
		
		//crear una lista vacia para meter los pro productos de la sesion
		List<TicketProducto> listaDeProductoTicket = new ArrayList<>();
		
		if(!listaDeAtributos.isEmpty()) {
			for(String producto : listaDeAtributos) {
				
				//Obtengo el objeto por el id que el el key de la sesion
				Producto prod = productoRep.getById(Integer.parseInt(producto));
				
				//Obtengo la cantidad de ese producto
				int cantidad = (int) session.getAttribute(producto);
				
				TicketProducto ticketProducto = new TicketProducto(cantidad, ticketGuardado, prod);
				
				listaDeProductoTicket.add(ticketProducto);
					
			}
			
			for(TicketProducto ticketProd : listaDeProductoTicket) {
				ticketProductoRep.save(ticketProd);
			}
		}
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping("/eliminarProductoTicket/{id}")
	public String eliminarProductoTicket(HttpSession session, @PathVariable int id) {
		
		String identificador = ""+id;
		
		session.removeAttribute(identificador);
		
		return "redirect:/";
	}
	
	@RequestMapping("/cancelarTicket")
	public String cancelarTicket(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
}
