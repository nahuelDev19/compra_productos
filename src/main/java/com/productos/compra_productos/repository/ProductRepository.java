package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.entityss.ProducEntity;

public interface ProductRepository extends JpaRepository<ProducEntity,Long>{

}
