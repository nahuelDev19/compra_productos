package com.productos.compra_productos.service.services;

public interface CrudService <RQ,RS,ID>{

    RS create(RQ rq);
    RS update(RQ rq,ID id);
    RS read(ID id);
    void delete(ID id);

}
