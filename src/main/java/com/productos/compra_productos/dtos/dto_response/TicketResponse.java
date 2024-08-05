package com.productos.compra_productos.dtos.dto_response;

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
public class TicketResponse {

        private TicketUserResponse user;
        private LocalDate date;
        private Set<ProductResponse> products;
        private Integer total;

}
