package com.maitena.service;

import java.util.List;
import java.util.Optional;

import com.maitena.model.Producto;

public interface IProductoService {

	public List<Producto> getProductoByCategoria(int id_categ);
	public void storeProducto(Producto producto);
	public Optional<Producto> findById(Integer id);
}
