package com.example.mercadopago.controller;

import com.example.mercadopago.model.dao.MercadoPagoDao;
import com.example.mercadopago.model.pojo.MercadoPago;
import com.example.mercadopago.util.ResultListener;

import java.util.List;

public class MercadoPagoController {

    public void mostrarModosDePago (String nombre, final ResultListener<MercadoPago> listernerDeLaVista){
        MercadoPagoDao mercadoPagoDao = new MercadoPagoDao();
        mercadoPagoDao.mostrarModosDePago(nombre, new ResultListener<MercadoPago>() {
            @Override
            public void notificar( MercadoPago resultado ) {
                listernerDeLaVista.notificar(resultado);

            }

            @Override
            public void finish( MercadoPago mercadoPago ) {

            }

            @Override
            public void finish( List<MercadoPago> mercadoPago ) {

            }
        });

    }

}
