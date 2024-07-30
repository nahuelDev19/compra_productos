package com.productos.compra_productos.service.implementservices;

import org.springframework.stereotype.Service;

import com.productos.compra_productos.dtos.dto_request.TicketRequest;
import com.productos.compra_productos.dtos.dto_response.TicketResponse;
import com.productos.compra_productos.service.services.TicketService;

@Service
public class TicketImplementService implements TicketService{

    @Override
    public TicketResponse create(TicketRequest rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
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

}
