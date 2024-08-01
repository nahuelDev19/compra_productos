package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.entityss.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity,Long>{

}
