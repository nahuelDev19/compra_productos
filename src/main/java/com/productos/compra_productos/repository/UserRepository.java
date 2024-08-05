package com.productos.compra_productos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.entityss.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{


    Optional<UserEntity> findFirstByNameContaining(String name);


}
