package com.productos.compra_productos.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SimpleGretedAuthorityJsonCreator {


    @JsonCreator
    public SimpleGretedAuthorityJsonCreator(@JsonProperty("authority") String role){}



}
