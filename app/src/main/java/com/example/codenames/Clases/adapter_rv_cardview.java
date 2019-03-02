package com.example.codenames.Clases;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.codenames.R;

import java.util.ArrayList;

public class adapter_rv_cardview extends RecyclerView.Adapter<adapter_rv_cardview.CardviewHolder> implements View.OnClickListener {

    ArrayList<Room> salas;
    private View.OnClickListener listener;
    private Context mContext;
    private View view;

    public adapter_rv_cardview(ArrayList<Room> salas, Context mContext, View view){
        this.salas= salas;
        this.mContext= mContext;
        this.view= view;
    }

    @Override
    public CardviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_rv, viewGroup, false);
        CardviewHolder holder= new CardviewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final CardviewHolder cardviewHolder, final int i) {

        //Moverle
        final Room sala= salas.get(i);
        cardviewHolder.Nombre.setText(sala.getName());


    }

    @Override
    public int getItemCount() {
        return salas.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener= listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public static class CardviewHolder extends RecyclerView.ViewHolder{
        TextView Nombre;


        public CardviewHolder(View itemView){
            super(itemView);
            Nombre= itemView.findViewById(R.id.rv_Nombre);
        }
    }
}
