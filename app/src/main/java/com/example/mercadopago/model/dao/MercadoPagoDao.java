package com.example.mercadopago.model.dao;

import com.example.mercadopago.model.pojo.MercadoPago;
import com.example.mercadopago.service.MercadoPagoService;
import com.example.mercadopago.util.PublicKey;
import com.example.mercadopago.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MercadoPagoDao {

    private String baseUrl;
    private Retrofit retrofit;
    private MercadoPagoService mercadoPagoService;


    public MercadoPagoDao() {

        this.baseUrl = "https://api.mercadopago.com/v1/";
        this.retrofit = new Retrofit.Builder()
                .baseUrl(this.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.mercadoPagoService = retrofit.create(MercadoPagoService.class);
    }


    public void mostrarModosDePago(String id, final ResultListener<MercadoPago> listernerDelControler) {

        mercadoPagoService.getModosDePagos(PublicKey.PUBLIC_KEY).enqueue(new Callback<MercadoPago>() {
            @Override
            public void onResponse(Call<MercadoPago> call, Response<MercadoPago> response) {
                MercadoPago contenedorProductos = response.body();
                listernerDelControler.notificar(contenedorProductos);

            }

            @Override
            public void onFailure(Call<MercadoPago> call, Throwable t) {
                System.out.println("Algo Falló");
            }
        });


    }
}
