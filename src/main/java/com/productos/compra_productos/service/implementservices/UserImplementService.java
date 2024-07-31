package com.productos.compra_productos.service.implementservices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.Entitys.UserEntity;
import com.productos.compra_productos.dtos.dto_request.UserRequest;
import com.productos.compra_productos.dtos.dto_response.UserResponse;
import com.productos.compra_productos.repository.UserRepository;
import com.productos.compra_productos.service.services.UserService;

@Service
public class UserImplementService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest rq) {
        UserEntity user= new UserEntity();
        user.setName(rq.getName());
        user.setLastname(rq.getLastname());
        user.setEmail(rq.getEmail());
        user.setPassword(rq.getPassword());
        user.setAge(rq.getAge());
        user.setRoles(rq.getRoles());
        userRepository.save(user);
        return this.convertidorResponse(user);
    }

    @Override
    public UserResponse update(UserRequest rq, Long id) {
        UserEntity user= userRepository.findById(id).orElseThrow();
        user.setName(rq.getName());
        user.setLastname(rq.getLastname());
        user.setEmail(rq.getEmail());
        user.setPassword(rq.getPassword());
        user.setAge(rq.getAge());
        user.setRoles(rq.getRoles());
        userRepository.save(user);
        return this.convertidorResponse(user);
    }

    @Override
    public UserResponse read(Long id) {
        UserEntity user= userRepository.findById(id).orElseThrow();
        return this.convertidorResponse(user);

    }

    @Override
    public void delete(Long id) {
        UserEntity user= userRepository.findById(id).orElseThrow();
        userRepository.delete(user);

    }


    private UserResponse convertidorResponse(UserEntity entity){
        UserResponse response= new UserResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

}
