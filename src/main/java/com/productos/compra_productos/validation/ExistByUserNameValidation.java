package com.productos.compra_productos.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productos.compra_productos.service.services.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class ExistByUserNameValidation implements ConstraintValidator<ExistByUserName,String>{

    @Autowired
    private UserService userService;

      @Override
    public boolean isValid(String userName, ConstraintValidatorContext context) {
        return !userService.existsByName(userName);

}
}