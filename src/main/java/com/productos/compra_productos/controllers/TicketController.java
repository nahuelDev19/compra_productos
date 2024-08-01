package com.productos.compra_productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.productos.compra_productos.dtos.dto_request.TicketRequest;
import com.productos.compra_productos.dtos.dto_response.TicketResponse;
import com.productos.compra_productos.service.services.TicketService;

@RestController @RequestMapping("/ticket")
public class TicketController {


    @Autowired
    private TicketService ticketService;

    @PostMapping("/create")
    public ResponseEntity<TicketResponse> createProduct(@RequestBody TicketRequest product) {
        return ResponseEntity.ok().body(ticketService.create(product));
    }
    @PutExchange("/update/{id}")
    public ResponseEntity<TicketResponse> updateProduct(@RequestBody TicketRequest producto, @PathVariable Long id) {
        return ResponseEntity.ok().body(ticketService.update(producto, id));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity<TicketResponse> searchProduct(@PathVariable Long id) {
        return ResponseEntity.ok().body(ticketService.read(id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        ticketService.delete(id);
        return ResponseEntity.noContent().build();
    }
    



}
