package com.productos.compra_productos.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.entityss.ProducEntity;

public interface ProductRepository extends JpaRepository<ProducEntity,Long>{


    Optional<ProducEntity> findByName(String string);

}
