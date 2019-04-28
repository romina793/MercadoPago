package com.example.mercadopago.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.mercadopago.R;
import com.example.mercadopago.controller.MercadoPagoController;
import com.example.mercadopago.model.pojo.ContenedorMercadoPago;
import com.example.mercadopago.model.pojo.MercadoPago;
import com.example.mercadopago.util.PublicKey;
import com.example.mercadopago.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class MedioDePago extends AppCompatActivity implements MercadoPagoAdapter.ListenerProductoAdapter{


    // creo una clave para evitar confuciones y crear un protocolo de comunicacion
    public static final String CLAVE_VALOR = "valorIngresado";
    private Double monto;
    private List<MedioDePago> medioDePago;
    private Integer cantidadDeCuotas;


    private TextView valorIngresado;
    private MercadoPagoController mostrarModosDePago;
    private PublicKey publicKey;

    private RecyclerView recyclerView;
    private MercadoPagoAdapter mercadoPagoAdapter;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medio_de_pago);

        valorIngresado = findViewById(R.id.ingrear_valor);
        mostrarModosDePago = new MercadoPagoController();
        medioDePago = new ArrayList<MedioDePago>();

        recyclerView = findViewById(R.id.recycler_medios_de_pago);
        mercadoPagoAdapter = new MercadoPagoAdapter();



        // agarro el intent
        Intent intent = getIntent();
        // agarro el bundle
        final Bundle bundle = intent.getExtras();
        // le pido al bundle el nombre del usuario usando la clave static que le asigne a la actividad
        final String valor = bundle.getString(CLAVE_VALOR);

        Toast.makeText(this, "Ahora vas a pagar " + valor, Toast.LENGTH_SHORT).show();

        MercadoPagoController mercadoPagoController = new MercadoPagoController();

        //creamos el layoutManager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setAdapter(mercadoPagoAdapter);
       /* mercadoPagoController.mostrarModosDePago(valor, new ResultListener<ContenedorMercadoPago>() {
            @Override
            public void notificar( ContenedorMercadoPago resultado ) {
                mercadoPagoAdapter.setMedioDePago(resultado.getResults());

            }

            @Override
            public void finish( MercadoPago mercadoPago ) {

            }

            @Override
            public void finish( List<MercadoPago> mercadoPago ) {

            }
        });*/

    }








    @Override
    public void informarSeleccion( MercadoPago mercadoPago ) {

    }
}




