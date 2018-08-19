package com.diego.ovocacional.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diego.ovocacional.R;
import com.diego.ovocacional.activities.SecondActivity;
import com.diego.ovocacional.models.Element;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<Element> elements;
    private Context context;

    public MainAdapter(List<Element> elements, Context context) {
        this.elements = elements;
        this.context = context;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_rv,parent,false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.title.setText(elements.get(position).getTitle());
        holder.desc.setText(elements.get(position).getSubtitle());
        holder.pic.setImageResource(elements.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private TextView title,desc;
        private ImageView pic;

        public MainViewHolder(View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.titulo_main);
            desc = itemView.findViewById(R.id.descripcion_main);
            pic = itemView.findViewById((R.id.img_season));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SecondActivity.class);
                    intent.putExtra("slc",getAdapterPosition());
                    context.startActivity(intent);
                }
            });
        }
    }
}