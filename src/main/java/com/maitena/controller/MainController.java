package com.maitena.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.maitena.model.Producto;
import com.maitena.repository.ProductoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	ProductoRepository productoRep;
	
	@GetMapping("/")
	public String startApp(HttpSession session, Model model) {

		model.addAttribute("atr_lista_productos", productoRep.findAll());
		
		Enumeration<String> enumerado = session.getAttributeNames();
		
		List<String> listaDeAtributos = Collections.list(enumerado);
		double totalTicket = 0.0;
		if(!listaDeAtributos.isEmpty()) {
			
			List<Map.Entry<Producto, Integer>> listaReal = new ArrayList<>();

			for (String elemento : listaDeAtributos) {

				Producto prod = productoRep.getById(Integer.parseInt(elemento));

				int cantidad = (int) session.getAttribute(elemento);
				totalTicket += prod.getPrecio()*cantidad;

				listaReal.add(new SimpleEntry<>(prod, cantidad));
			}
			
			model.addAttribute("atr_datos_en_sesion", listaReal);
				
		}
		
		model.addAttribute("atr_total_ticket", totalTicket);
		
		return "home";
	}
}
