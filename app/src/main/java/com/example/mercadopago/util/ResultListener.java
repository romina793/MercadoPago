package com.example.mercadopago.util;

import com.example.mercadopago.model.pojo.MercadoPago;

import java.util.List;

public interface ResultListener <T> {

    void notificar (T resultado);

    void finish( MercadoPago mercadoPago );

    void finish( List<MercadoPago> mercadoPago );
}
