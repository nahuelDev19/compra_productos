package com.productos.compra_productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.productos.compra_productos.dtos.dto_request.ProductRequest;
import com.productos.compra_productos.dtos.dto_response.ProductResponse;
import com.productos.compra_productos.service.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController @RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest product) {
        return ResponseEntity.ok().body(productService.create(product));
    }
    @PutExchange("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@RequestBody ProductRequest producto, @PathVariable Long id) {
        return ResponseEntity.ok().body(productService.update(producto, id));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<ProductResponse> searchProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.read(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
    

}
