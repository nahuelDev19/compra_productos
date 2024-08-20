package com.productos.compra_productos.service.services;

import com.productos.compra_productos.dtos.dto_request.UserRequest;
import com.productos.compra_productos.dtos.dto_response.UserResponse;

public interface UserService extends CrudService<UserRequest, UserResponse, Long>{


    boolean existsByName(String string);


}
