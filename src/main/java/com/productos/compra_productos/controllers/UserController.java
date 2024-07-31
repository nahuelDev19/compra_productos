package com.productos.compra_productos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.compra_productos.dtos.dto_request.UserRequest;
import com.productos.compra_productos.dtos.dto_response.UserResponse;
import com.productos.compra_productos.service.services.UserService;

@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRequest request){
        UserResponse response = userService.create(request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> userUpdete(@RequestBody UserRequest request, @PathVariable Long id){
        UserResponse response = userService.update(request,id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<UserResponse> userSearch(@PathVariable Long id){
        UserResponse response = userService.read(id);
        return ResponseEntity.ok().body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> userDelete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
