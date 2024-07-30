package com.productos.compra_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.Entitys.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
