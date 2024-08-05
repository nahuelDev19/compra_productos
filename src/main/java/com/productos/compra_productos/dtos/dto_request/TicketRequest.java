package com.productos.compra_productos.dtos.dto_request;

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
    private UserRequest userEntity;
    private Set<ProductRequest> products;
    private Integer total;


}
