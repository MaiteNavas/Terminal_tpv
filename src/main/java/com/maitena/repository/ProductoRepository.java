package com.maitena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maitena.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query(value = "SELECT * FROM producto where categoria_id=:valor", nativeQuery = true)
	List<Producto> getProductoByCategoria(@Param("valor") int valor);
}
