package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.entityss.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
