package com.maitena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.maitena.model.TicketProducto;

@Repository
public interface TicketProductoRepository extends JpaRepository<TicketProducto,Integer>{
	
	@Query(value = "SELECT * FROM tickets_productos WHERE ticket_id = :ticket_id", nativeQuery = true)
	List<TicketProducto> obtenerProductosPorIdTicket(@Param("ticket_id") int ticket_id);

}
