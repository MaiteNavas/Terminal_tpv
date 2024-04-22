package com.maitena.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maitena.model.Categoria;
import com.maitena.model.Producto;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class InicializarDatos {
	
	@Autowired
	private IProductoService productoServ;
	
	@Autowired
	private ICategoriaService categoriaServ;

	@PostConstruct
	@Transactional 
	public void cargarDatosBD() {
		
		Categoria bebidas = new Categoria(1,"bebidas");
		categoriaServ.storeCategoria(bebidas);
		
		Categoria raciones = new Categoria(2,"raciones");
		categoriaServ.storeCategoria(raciones);
		
		productoServ.storeProducto(new Producto(1, "Croquetas de bacalao", 3.00, "croquetas_baca.jpg", 10,raciones));
		productoServ.storeProducto(new Producto(2, "Croquetas de jamón", 4.00, "croquetas_jam.jpg", 10, raciones));
		productoServ.storeProducto(new Producto(3, "Gilda", 1.00, "gilda.jpg", 10, raciones));
		productoServ.storeProducto(new Producto(4, "Pincho de tortilla", 2.50, "pincho_tortilla.jpg", 10, raciones));
		productoServ.storeProducto(new Producto(5, "Pincho de bacalao", 3.50, "pincho_baca.jpg", 10, raciones));
		productoServ.storeProducto(new Producto(6, "Txakoli", 2.00, "txakoli.jpg", 21, bebidas));
		productoServ.storeProducto(new Producto(7, "Botella de agua", 1.00, "botella_agua.jpg", 10, bebidas));
		productoServ.storeProducto(new Producto(8, "Caña cerveza", 1.50, "cana_cerveza.jpg", 21, bebidas));
		productoServ.storeProducto(new Producto(9, "Doble cerveza", 2.50, "doble_cerveza.jpg", 21, bebidas));
		productoServ.storeProducto(new Producto(10, "Jarra cerveza", 3.10, "jarra_cerveza.jpg", 21, bebidas));
		productoServ.storeProducto(new Producto(11, "Refresco", 2.20, "refresco.jpg", 10, bebidas));
		productoServ.storeProducto(new Producto(12, "Café solo", 1.40, "cafe_solo.jpg", 10, bebidas));
		productoServ.storeProducto(new Producto(13, "Café con leche", 1.50, "cafe_leche.jpg", 10, bebidas));
	
	}
}
