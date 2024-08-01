package com.productos.compra_productos.dtos.dto_response;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private Set<RoleResponse> roles;

    private Boolean admin;

}
