package com.diego.ovocacional.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diego.ovocacional.R;
import com.diego.ovocacional.Utilities.Utilities;
import com.diego.ovocacional.adapters.UniversidadesAdapter;
import com.diego.ovocacional.models.Carrera;
import com.diego.ovocacional.models.Universidad;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaUniPrivadasFragment extends Fragment {

    private ArrayList<Universidad> universidads;
    private UniversidadesAdapter adapter;
    private RecyclerView recyclerView;


    public ListaUniPrivadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_lista_uni_privadas, container, false);
        AppCompatActivity activity = (AppCompatActivity) getContext();
        Bundle bundle = activity.getIntent().getExtras();
        String nombre =  bundle.getString("uni");
        universidads = selectUni(nombre);
        recyclerView = v.findViewById(R.id.uni_priv_rv);
        adapter = new UniversidadesAdapter(universidads,getContext());
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        return v;
    }

    private ArrayList<Universidad> selectUni(String n) {
        ArrayList<Universidad> aux= new ArrayList<>();
        for(int i = 0 ; i<Utilities.universidades.size();i++){
            for(int j = 0; j<Utilities.universidades.get(i).getCarreras().size();j++) {
                if (TextUtils.equals(n, Utilities.universidades.get(i).getCarreras().get(j).getNombre())&&TextUtils.equals(Utilities
                        .universidades.get(i).getTipo(),"PRIVADA")) {
                    aux.add(Utilities.universidades.get(i));
                }
            }
        }

       return aux;
    }

}
