package com.productos.compra_productos.service.implementservices;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.ProductRequest;
import com.productos.compra_productos.dtos.dto_response.ProductResponse;
import com.productos.compra_productos.service.services.ProductService;

@Service

public class ProductImplementService implements ProductService{

    @Override
    public ProductResponse create(ProductRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public ProductResponse update(ProductRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ProductResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
