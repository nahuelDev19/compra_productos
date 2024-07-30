package com.productos.compra_productos.dtos.dto_request;

import java.time.LocalDate;
import java.util.Set;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketRequest {


    private Long id;
    private LocalDate date;
    private UserRequest userRequest;
    private Integer total;
    private Set<ProductRequest> products;


}
