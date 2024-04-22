package com.maitena.controller;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.maitena.model.Producto;
import com.maitena.repository.ProductoRepository;
import com.maitena.repository.TicketRepository;
import com.maitena.service.IProductoService;


@Controller
public class AdminController {
	
	@Autowired
	IProductoService productoServ;
	
	@Autowired
	TicketRepository ticketRep;
	
	@PostMapping("/crearProducto")
	public String crearProducto(@ModelAttribute @Validated Producto objeto_producto, BindingResult result, @RequestParam("foto") MultipartFile foto, Model model) {
			
		String ruta = "/Users/maitenavas/Documents/PROGRAMACION/JAVA/Spring 4.21.0/WorkspaceSpring/Terminal_tpv/src/main/resources/static/images";
		
		File directorio = new File(ruta);
		
		if(!directorio.exists()) {
			
			directorio.mkdirs();
			System.out.println("Se ha creado la carpeta");
			
		}else {
			System.out.println("La carpeta exisiste");
		}
		
		try {
			
			String nombreArchivo = foto.getOriginalFilename();				
			File archivo = new File(ruta + "/" + nombreArchivo);
			foto.transferTo(archivo);
			objeto_producto.setFoto(nombreArchivo);
			productoServ.storeProducto(objeto_producto);
					
		} catch (IOException e) {
			e.printStackTrace();
		}	

		return "redirect:/admin";
	}
	
	@RequestMapping("/editarProducto/{id}")
	public String editarProducto(@PathVariable Integer id, Model model) {
		
		Optional<Producto> producto = productoServ.findById(id);
		model.addAttribute("objeto_producto", producto);
		
		return "editar_producto";
	}
	
	@RequestMapping("/actualizarProducto")
	public String actualizarProducto(@ModelAttribute Producto objeto_producto) {
		
		productoServ.storeProducto(objeto_producto);
		
		return "redirect:/admin";	
	}
	
}
