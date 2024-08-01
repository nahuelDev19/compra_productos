package com.productos.compra_productos.entityss;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TicketEntity representa un ticket o factura en el sistema de compra de productos.
 * Esta clase es una entidad JPA que mapea la tabla 'ticket' en la base de datos.
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
 * - @ManyToOne: Define una relación muchos a uno con la entidad UserEntity.
 * - @JoinColumn: Especifica la columna que se usará para la unión con UserEntity.
 * - @ManyToMany: Define una relación muchos a muchos con la entidad ProducEntity.
 * - @JoinTable: Define la tabla intermedia para la relación muchos a muchos.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Usuario al que pertenece el ticket.
     * La relación es muchos a uno.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    
    private LocalDate date;
    private Integer total;

    /**
     * Productos asociados al ticket.
     * La relación es muchos a muchos.
     * 
     * La tabla intermedia 'ticket_product' contiene las uniones entre tickets y productos.
     * - joinColumns: Define la columna en la tabla intermedia que se une con la entidad actual (TicketEntity).
     * - inverseJoinColumns: Define la columna en la tabla intermedia que se une con la otra entidad (ProducEntity).
     */
    @ManyToMany
    @JoinTable(name = "ticket_product",
               joinColumns = @JoinColumn(name = "ticket_id"),
               inverseJoinColumns = @JoinColumn(name = "produc_id"))
    private Set<ProducEntity> products;

}
