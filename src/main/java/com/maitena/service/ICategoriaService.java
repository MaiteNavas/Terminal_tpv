package com.maitena.service;

import java.util.List;

import com.maitena.model.Categoria;

public interface ICategoriaService {
	public List<Categoria> getAllCategorias();
	public void storeCategoria(Categoria categoria);
}
