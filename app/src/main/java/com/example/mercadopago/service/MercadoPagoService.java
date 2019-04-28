package com.example.mercadopago.service;



import com.example.mercadopago.model.pojo.MercadoPago;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercadoPagoService {

    @GET ("payment_methods?")
    Call<MercadoPago> getModosDePagos(@Query("public_key") String apiKey);

}
