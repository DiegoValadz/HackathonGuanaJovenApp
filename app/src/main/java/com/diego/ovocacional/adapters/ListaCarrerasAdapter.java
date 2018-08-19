package com.diego.ovocacional.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diego.ovocacional.R;
import com.diego.ovocacional.activities.SecondActivity;
import com.diego.ovocacional.models.Carrera;

import java.util.ArrayList;

public class ListaCarrerasAdapter extends RecyclerView.Adapter<ListaCarrerasAdapter.ListaCarrVH>{
    private Context context;
    private ArrayList<Carrera> carreras;

    public ListaCarrerasAdapter(Context context, ArrayList<Carrera> carreras) {
        this.context = context;
        this.carreras = carreras;
    }

    @NonNull
    @Override
    public ListaCarrVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_lista_carreras_rv,parent,false);
        return new ListaCarrVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaCarrVH holder, int position) {
        holder.nombre.setText(carreras.get(position).getNombre());
        holder.duracion.setText(carreras.get(position).getDuracion());

    }

    @Override
    public int getItemCount() {
        return carreras.size();
    }

    public class ListaCarrVH extends RecyclerView.ViewHolder {
        private TextView nombre, duracion;
        public ListaCarrVH(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_carrera);
            duracion = itemView.findViewById(R.id.duracion_carrera);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra("uni",carreras.get(getAdapterPosition()).getNombre());
                    context.startActivity(intent);
                }
            });
        }
    }
}
