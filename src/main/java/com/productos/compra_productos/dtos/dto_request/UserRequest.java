package com.productos.compra_productos.dtos.dto_request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private Long id;
    private String name;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private Boolean admin;

}
