package com.diego.ovocacional.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.diego.ovocacional.R;
import com.diego.ovocacional.models.Universidad;

import java.util.ArrayList;

public class UniversidadesAdapter extends RecyclerView.Adapter<UniversidadesAdapter.ListaUniVH> {

    private ArrayList<Universidad> universidads;
    private Context context;

    public UniversidadesAdapter(ArrayList<Universidad> universidads, Context context) {
        this.universidads = universidads;
        this.context = context;
    }

    @NonNull
    @Override
    public ListaUniVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_lista_unis,parent,false);
        return new ListaUniVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaUniVH holder, int position) {
        holder.nombreUni.setText(universidads.get(position).getNombre());
      //  holder.desc.setText(elements.get(position).getSubtitle());
       // holder.logo.setImageResource(universidads.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return universidads.size();
    }

    public class ListaUniVH extends RecyclerView.ViewHolder {
        private ImageView logo;
        private TextView nombreUni,otro;
        public ListaUniVH(View itemView) {
            super(itemView);
            nombreUni= itemView.findViewById(R.id.nombre_uni);
            logo = itemView.findViewById(R.id.logo_uni_rv);

        }
    }
}
