package com.productos.compra_productos.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RoleEntity representa un rol de usuario en el sistema de compra de productos.
 * Esta clase es una entidad JPA que mapea la tabla 'role' en la base de datos.
 * Utiliza Lombok para generar código boilerplate como constructores, getters, setters y métodos toString, equals y hashCode.
 * 
 * Anotaciones de Lombok:
 * - @Data: Genera getters y setters para todos los campos, así como los métodos toString, equals y hashCode.
 * - @AllArgsConstructor: Genera un constructor con un parámetro para cada campo en la clase.
 * - @NoArgsConstructor: Genera un constructor sin parámetros.
 * - @Builder: Proporciona un patrón de diseño Builder para crear instancias de la clase.
 * 
 * Anotaciones de JPA:
 * - @Entity: Marca esta clase como una entidad JPA.
 * - @Id: Indica que el campo 'id' es la clave primaria de la entidad.
 * - @GeneratedValue: Especifica que el valor de 'id' se generará automáticamente. La estrategia de generación es IDENTITY.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RoleEntity {

    /**
     * Identificador único del rol. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del rol.
     */
    private String roles;
}
