package com.productos.compra_productos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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
import static com.productos.compra_productos.validation.ValidationResult.*;
import jakarta.validation.Valid;

@RestController @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    //@PreAuthorize("hasRoel('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody UserRequest request, BindingResult result){
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        UserResponse response = userService.create(request);
        return ResponseEntity.ok().body(response);
    }
    //la seguridad de esta clase se encuentra en la clase SecurityConfig
    // todos se pueden loguear pero por defecto sos usuario
    @PostMapping("/register")
    public ResponseEntity<?> registercreate(@Valid @RequestBody UserRequest request, BindingResult result){
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        request.setAdmin(false);
        return create(request, result);
    }
    @PreAuthorize("hasAnyRoel('ADMIN','USER')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> userUpdete(@Valid @RequestBody UserRequest request, BindingResult result, @PathVariable Long id){
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        UserResponse response = userService.update(request,id);
        return ResponseEntity.ok().body(response);
    }
    //la seguridad de esta clase se encuentra en la clase SecurityConfig
    @GetMapping("/search/{id}")
    public ResponseEntity<UserResponse> userSearch(@PathVariable Long id){
        UserResponse response = userService.read(id);
        return ResponseEntity.ok().body(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> userDelete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    
}
