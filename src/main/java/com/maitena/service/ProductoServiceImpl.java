package com.maitena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maitena.model.Producto;
import com.maitena.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public List<Producto>  getProductoByCategoria(int id_categ) {
		
		List<Producto> listProducto = productoRepo.getProductoByCategoria(id_categ);
		
		return listProducto;
	}

	@Override
	public void storeProducto(Producto producto) {
		
		productoRepo.save(producto);
		
	}

	@Override
	public Optional<Producto> findById(Integer id) {
		
		return Optional.empty();
	}
}
