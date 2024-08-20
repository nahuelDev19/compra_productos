package com.productos.compra_productos.dtos.dto_request;



import jakarta.validation.constraints.NotBlank;
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
    //@ExistByUserName
    @NotBlank
    private String name;
    private String lastname;
    private Integer age;
    private String email;
    private String password;
    private Boolean admin;

}
