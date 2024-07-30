package com.productos.compra_productos.service.implementservices;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.UserRequest;
import com.productos.compra_productos.dtos.dto_response.UserResponse;
import com.productos.compra_productos.service.services.UserService;

@Service

public class UserImplementService implements UserService{

    @Override
    public UserResponse create(UserRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public UserResponse update(UserRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UserResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
