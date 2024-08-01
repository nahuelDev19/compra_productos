package com.productos.compra_productos.service.implementservices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.ProductRequest;
import com.productos.compra_productos.dtos.dto_response.ProductResponse;
import com.productos.compra_productos.entityss.ProducEntity;
import com.productos.compra_productos.repository.ProductRepository;
import com.productos.compra_productos.service.services.ProductService;

@Service
public class ProductImplementService implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductRequest rq) {
        ProducEntity produ= new ProducEntity();
        produ.setName(rq.getName());
        produ.setDescription(rq.getDescription());
        produ.setPrice(rq.getPrice());
        productRepository.save(produ);
        return convertidorResponse(produ);
    }

    @Override
    public ProductResponse update(ProductRequest rq, Long id) {
        ProducEntity produ= productRepository.findById(id).orElseThrow();
        produ.setName(rq.getName());
        produ.setDescription(rq.getDescription());
        produ.setPrice(rq.getPrice());
        productRepository.save(produ);
        return convertidorResponse(produ);
    }

    @Override
    public ProductResponse read(Long id) {
        ProducEntity produ= productRepository.findById(id).orElseThrow();
        return convertidorResponse(produ);
    }

    @Override
    public void delete(Long id) {
        ProducEntity produ= productRepository.findById(id).orElseThrow();
        productRepository.delete(produ);
    }

    private ProductResponse convertidorResponse(ProducEntity entity){
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
