package com.productos.compra_productos.dtos.dto_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketUserResponse {

     private Long id;
    private String name;
    private String lastname;
    private Integer age;
}
