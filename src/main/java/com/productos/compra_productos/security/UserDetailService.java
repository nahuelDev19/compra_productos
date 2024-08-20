package com.productos.compra_productos.security;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.entityss.UserEntity;
import com.productos.compra_productos.repository.UserRepository;

@Service
public class UserDetailService implements UserDetailsService{


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional= userRepository.findByName(username);
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException(String.format("name %s no existe en nuestro sistema.",username));
        }
        UserEntity user= userOptional.orElseThrow();

        List<GrantedAuthority> authorities= user.getRoles().stream()
        .map(role->new SimpleGrantedAuthority(role.getRoles()))
        .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
            user.getName(),
            user.getPassword(),
            true, 
            true,
            true,
            true, authorities
        );
    }

    

}
