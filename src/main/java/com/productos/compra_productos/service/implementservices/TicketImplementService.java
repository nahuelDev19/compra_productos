package com.productos.compra_productos.service.implementservices;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.ProductRequest;
import com.productos.compra_productos.dtos.dto_request.TicketRequest;
import com.productos.compra_productos.dtos.dto_response.ProductResponse;
import com.productos.compra_productos.dtos.dto_response.TicketResponse;
import com.productos.compra_productos.dtos.dto_response.TicketUserResponse;
import com.productos.compra_productos.entityss.ProducEntity;
import com.productos.compra_productos.entityss.TicketEntity;
import com.productos.compra_productos.entityss.UserEntity;
import com.productos.compra_productos.repository.ProductRepository;
import com.productos.compra_productos.repository.TicketRepository;
import com.productos.compra_productos.repository.UserRepository;
import com.productos.compra_productos.service.services.TicketService;

@Service
public class TicketImplementService implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public TicketResponse create(TicketRequest rq) {
        TicketEntity ticket= new TicketEntity();
        ticket.setDate(LocalDate.now());
        //trayendo el usuario dueño del tickt
        UserEntity user= userRepository.findFirstByNameContaining(rq.getUserEntity().getName()).orElseThrow();
        ticket.setUserEntity(user);
        //llenando los campos de productos que entran el ticket
        Set<ProducEntity> listProduc= new HashSet<>();
        Integer total= 0;
        for(ProductRequest pro: rq.getProducts()){
            //buscando producto por su nombre en la bd
            Optional<ProducEntity> proOptional= productRepository.findByName(pro.getName());
            ProducEntity newPro= proOptional.orElseThrow();
            pro.setId(newPro.getId());
            pro.setName(newPro.getName());
            pro.setDescription(newPro.getDescription());
            pro.setPrice(newPro.getPrice());
            listProduc.add(newPro);
            total+=pro.getPrice();
        }
        ticket.setProducts(listProduc);
        ticket.setTotal(total);
        ticketRepository.save(ticket);
        return convertidorTicket(ticket);
    }

    @Override
    public TicketResponse update(TicketRequest rq, Long id) {
        TicketEntity ticket= ticketRepository.findById(id).orElseThrow();
        ticket.setDate(LocalDate.now());
        //trayendo el usuario dueño del tickt
        UserEntity user= userRepository.findFirstByNameContaining(rq.getUserEntity().getName()).orElseThrow();
        ticket.setUserEntity(user);
        //llenando los campos de productos que entran el ticket
        Set<ProducEntity> listProduc= new HashSet<>();
        Integer total= 0;
        for(ProductRequest pro: rq.getProducts()){
            //buscando producto por su nombre en la bd
            Optional<ProducEntity> proOptional= productRepository.findByName(pro.getName());
            ProducEntity newPro= proOptional.orElseThrow();
            pro.setId(newPro.getId());
            pro.setName(newPro.getName());
            pro.setDescription(newPro.getDescription());
            pro.setPrice(newPro.getPrice());
            listProduc.add(newPro);
            total+=pro.getPrice();
        }
        ticket.setProducts(listProduc);
        ticket.setTotal(total);
        ticketRepository.save(ticket);
        return convertidorTicket(ticket);
    }

    @Override
    public TicketResponse read(Long id) {
        TicketEntity ticket= ticketRepository.findById(id).orElseThrow();
        return this.convertidorTicket(ticket);
    }

    @Override
    public void delete(Long id) {
        TicketEntity ticket= ticketRepository.findById(id).orElseThrow();
        ticketRepository.delete(ticket);;
    }


     private TicketResponse convertidorTicket(TicketEntity entity){
        TicketResponse response= new TicketResponse();

        //asignando el campo user al ticket response
        TicketUserResponse user= new TicketUserResponse();
        BeanUtils.copyProperties(entity.getUserEntity(), user);        
        response.setUser(user);

        // se asignan los productos al ticket response
        BeanUtils.copyProperties(entity, response);
       response.setProducts(entity.getProducts().stream()
        .map(produc -> {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(produc.getId());
            productResponse.setName(produc.getName());
            productResponse.setDescription(produc.getDescription());
            productResponse.setPrice(produc.getPrice());
            return productResponse;
        })
        .collect(Collectors.toSet()));
        return response;
    } 
}
