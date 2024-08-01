package com.productos.compra_productos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.compra_productos.Entitys.RoleEntity;


public interface RoleRepository extends JpaRepository<RoleEntity,Long>{

    Optional<RoleEntity> findByRoles(String roles);

}
