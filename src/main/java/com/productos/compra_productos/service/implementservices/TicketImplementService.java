package com.productos.compra_productos.service.implementservices;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.TicketRequest;
import com.productos.compra_productos.dtos.dto_response.TicketResponse;
import com.productos.compra_productos.entityss.TicketEntity;
import com.productos.compra_productos.service.services.TicketService;

@Service
public class TicketImplementService implements TicketService{

    @Override
    public TicketResponse create(TicketRequest rq) {
        TicketEntity ticket= new TicketEntity();
        ticket.setDate(LocalDate.now());
        ticket.setProducts(null);
        ticket.setTotal(null);
        return convertidorTicket(ticket);
    }

    @Override
    public TicketResponse update(TicketRequest rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public TicketResponse read(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    private TicketResponse convertidorTicket(TicketEntity entity){
        TicketResponse response= new TicketResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
