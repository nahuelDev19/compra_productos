package com.productos.compra_productos.Entitys;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserEntity representa un usuario en el sistema de compra de productos.
 * Esta clase es una entidad JPA que mapea la tabla 'usuario' en la base de datos.
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
 * - @ManyToMany: Define una relación muchos a muchos con la entidad RoleEntity.
 * - @JoinTable: Define la tabla intermedia para la relación muchos a muchos.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    /**
     * Identificador único del usuario. Se genera automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario.
     */
    private String name;

    /**
     * Apellido del usuario.
     */
    private String lastname;

    /**
     * Edad del usuario.
     */
    private Integer age;

    /**
     * Correo electrónico del usuario.
     */
    private String email;

    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Roles del usuario.
     * La relación es muchos a muchos y se carga de forma ansiosa (EAGER).
     * 
     * La tabla intermedia 'usuario_roles' contiene las uniones entre usuarios y roles.
     * - joinColumns: Define la columna en la tabla intermedia que se une con la entidad actual (UserEntity).
     * - inverseJoinColumns: Define la columna en la tabla intermedia que se une con la otra entidad (RoleEntity).
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
               joinColumns = @JoinColumn(name = "usuario_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

}
