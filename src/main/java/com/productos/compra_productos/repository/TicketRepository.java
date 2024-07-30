package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.Entitys.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity,Long>{

}
