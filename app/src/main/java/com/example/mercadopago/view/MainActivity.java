package com.example.mercadopago.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mercadopago.R;
import com.example.mercadopago.util.PublicKey;


public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Button buttonPagar;
    private TextView textViewPagar;
    private EditText ingresarValor;
    private PublicKey publicKey;
    public static final Integer MONTO_A_COBRAR = 1;




    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    buttonPagar = findViewById(R.id.button_pagar);
    textViewPagar= findViewById(R.id.mp_results);
     ingresarValor= findViewById(R.id.ingrear_valor);


    buttonPagar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick( View view ) {

                // agarro el valor del edit text
                String nombre = ingresarValor.getText().toString();
                // creo el bundle
                Bundle bundle = new Bundle();
                // le pongo el string con el nombre del usuario
                bundle.putString(MedioDePago.CLAVE_VALOR,nombre);
                // creo la intencion de cambiar de actividad
                Intent intent = new Intent(MainActivity.this,MedioDePago.class);
                // el pongo el bundle
                intent.putExtras(bundle);
                // le digo al sistema operativo que arranque
                startActivity(intent);



        }
    });



    }

}

