package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.Entitys.ProducEntity;

public interface ProductRepository extends JpaRepository<ProducEntity,Long>{

}
