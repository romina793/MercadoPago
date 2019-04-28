package com.example.mercadopago.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mercadopago.R;
import com.example.mercadopago.model.pojo.MercadoPago;

import java.util.ArrayList;
import java.util.List;

public class MercadoPagoAdapter extends RecyclerView.Adapter {

    private List<MercadoPago> medioDePago;

    public MercadoPagoAdapter( ) {
        this.medioDePago = new ArrayList<>();
    }

    public void setMedioDePago( List<MercadoPago> medioDePago ) {
        this.medioDePago = medioDePago;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType ) {
        View viewCelda = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_medios_de_pago,parent,false);
        ViewHolderMediosDePago viewHolderMediosDePago = new ViewHolderMediosDePago(viewCelda);
        return viewHolderMediosDePago;    }

    @Override
    public void onBindViewHolder( @NonNull RecyclerView.ViewHolder viewHolder, int position ) {
        ViewHolderMediosDePago viewHolderMediosDePago = (ViewHolderMediosDePago) viewHolder;
        viewHolderMediosDePago.loadMercadoPago(medioDePago.get(position));
    }

    @Override
    public int getItemCount() {
        return medioDePago.size();
    }


    private class ViewHolderMediosDePago extends RecyclerView.ViewHolder{

        private TextView textViewNombre;

        public ViewHolderMediosDePago( View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.celda_nombre_pago);
        }

        public void loadMercadoPago( MercadoPago medioDePago){
            textViewNombre.setText(medioDePago.getId());
        }
    }

    //1. definir una interface
    public interface ListenerProductoAdapter {
        //2. el método es lo que queremos comunicar
        public void informarSeleccion (MercadoPago mercadoPago);

    }

}



