package com.productos.compra_productos.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productos.compra_productos.entityss.UserEntity;

import static com.productos.compra_productos.security.TokenJwtConfig.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

     @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
                UserEntity user= null;
                String name=null;
                String password=null;
                try {
                    
                    user = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);

                    name= user.getName();
                    password= user.getPassword();
                } catch (StreamReadException e) {
                    e.printStackTrace();
                } catch (DatabindException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(name, password);
        return authenticationManager.authenticate(authenticationToken);
    } 

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
                User user= (User)authResult.getPrincipal();
                String username=user.getUsername();

                Collection<? extends GrantedAuthority> roles= authResult.getAuthorities();

                Claims claims= Jwts.claims()
                .add("authorities", new ObjectMapper().writeValueAsString(roles))
                .add("username",username)
                .build();



                String token = Jwts.builder()
                .subject(username)
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis()+3600000))
                .issuedAt(new Date())
                .signWith(KEY)
                .compact();

                response.addHeader(HEADER_AUTHRIZATION, PREFIX_TOKEN+ token);

                Map<String, String> body= new HashMap<>();
                body.put("token", token);
                body.put("username", username);
                body.put("message", String.format("hola %s has iniciado secion con exito!",username));

                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setContentType(CONTENT_TYPE);
                response.setStatus(200);}

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
                Map<String, String> body= new HashMap<>();
                body.put("message", "los datos ingresados no son correctos");
                body.put("error", failed.getMessage());

                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setContentType(CONTENT_TYPE);
                response.setStatus(401);

                



    }

                
    

}
