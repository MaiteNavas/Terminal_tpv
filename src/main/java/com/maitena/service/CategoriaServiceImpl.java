package com.maitena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maitena.model.Categoria;
import com.maitena.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public List<Categoria> getAllCategorias() {
		
		List<Categoria> listCategorias = categoriaRepo.findAll();
		
		return listCategorias;
	}

	@Override
	public void storeCategoria(Categoria categoria) {
		
		categoriaRepo.save(categoria);
		
	}
}
