package com.productos.compra_productos.service.implementservices;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.Entitys.RoleEntity;
import com.productos.compra_productos.Entitys.UserEntity;
import com.productos.compra_productos.dtos.dto_request.RoleRequest;
import com.productos.compra_productos.dtos.dto_request.UserRequest;
import com.productos.compra_productos.dtos.dto_response.RoleResponse;
import com.productos.compra_productos.dtos.dto_response.UserResponse;
import com.productos.compra_productos.repository.RoleRepository;
import com.productos.compra_productos.repository.UserRepository;
import com.productos.compra_productos.service.services.UserService;

@Service
public class UserImplementService implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    // v1 problemas para asignar usuario con el is admin 
    //retorna null el user
    /* @Override
    public UserResponse create(UserRequest rq) {
        UserEntity user= new UserEntity();
        user.setName(rq.getName());
        user.setLastname(rq.getLastname());
        user.setEmail(rq.getEmail());
        user.setPassword(rq.getPassword());
        user.setAge(rq.getAge());

        //asignando rol
        Optional<RoleEntity> roleOptional= roleRepository.findByRoles("ROLE_USER");
        Set<RoleEntity> roles= new HashSet<>();
        roleOptional.ifPresent(roles::add);
        if (rq.getIsAdmin()) {
            Optional<RoleEntity> roleOptionalAdmin= roleRepository.findByRoles("ROLE_ADMIN");
            roleOptionalAdmin.ifPresent(roles::add);
        }
        user.setRoles(roles);
        userRepository.save(user);
        return this.convertidorResponse(user);
    } */

    @Override
    public UserResponse create(UserRequest rq) {
        UserEntity user= new UserEntity();
        user.setName(rq.getName());
        user.setLastname(rq.getLastname());
        user.setEmail(rq.getEmail());
        user.setPassword(rq.getPassword());
        user.setAge(rq.getAge());
        user.setAdmin(rq.getAdmin());
        Set<RoleEntity> roles= new HashSet<>();
        Optional<RoleEntity> roleOptional= roleRepository.findByRoles("ROLE_USER");
        roleOptional.ifPresent(roles::add);
        if (Boolean.TRUE.equals(rq.getAdmin())) {
            Optional<RoleEntity> roleOptionalAdmin= roleRepository.findByRoles("ROLE_ADMIN");
            roleOptionalAdmin.ifPresent(roles::add);
        }
         user.setRoles(roles);
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
        Set<RoleEntity> roles= new HashSet<>();
      /*   if (rq.getRoles()!=null) {
            for(RoleRequest rol: rq.getRoles()){
                Optional<RoleEntity> rolEnty= roleRepository.findByRoles(rol.getRole());
                roles.add(rolEnty.get());
            }
        } *//*  */
        user.setRoles(roles);
        user.setAdmin(rq.getAdmin());

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

    private UserResponse convertidorResponse(UserEntity entity) {
        UserResponse response = new UserResponse();
        BeanUtils.copyProperties(entity, response);
    
        //response.setAdmin(entity.getAdmin());
        // Mapeo de roles de UserEntity a RoleResponse
        response.setRoles(entity.getRoles().stream()
            .map(role -> {
                RoleResponse roleResponse = new RoleResponse();
                roleResponse.setRole(role.getRoles()); // Aquí se usa getRoles()
                return roleResponse;
            })
            .collect(Collectors.toSet()));
    
        return response;
    }
    


}
