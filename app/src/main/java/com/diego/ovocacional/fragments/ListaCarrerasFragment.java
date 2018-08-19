package com.diego.ovocacional.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diego.ovocacional.R;
import com.diego.ovocacional.Utilities.Utilities;
import com.diego.ovocacional.adapters.ListaCarrerasAdapter;
import com.diego.ovocacional.models.Carrera;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCarrerasFragment extends Fragment {

    private Fragment fragment;
    private  ArrayList<Carrera> carreras;
    private ListaCarrerasAdapter adapter;
    private RecyclerView recyclerView;


    public ListaCarrerasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_lista_carreras, container, false);
        recyclerView = v.findViewById(R.id.rv_carreras);
           carreras = selectCarrera(getArguments().getInt("pos"));
        adapter = new ListaCarrerasAdapter(getContext(),carreras);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
       recyclerView.setAdapter(adapter);
       recyclerView.setLayoutManager(llm);

       return v;
    }

    private ArrayList<Carrera> selectCarrera(int s) {
        ArrayList<Carrera> aux = new ArrayList<>();
        switch (s){
            case 0:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Matematicas",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                        aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                    }
                }
                }
                break;

            case 1:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Informatica",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                            aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                        }
                    }
                }
                break;

            case 2:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Mecanica",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                            aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                        }
                    }
                }
                break;

            case 3:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Electrica",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                            aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                        }
                    }
                }
                break;

            case 4:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Electronica",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                            aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                        }
                    }
                }
                break;

            case 5:
                for (int i = 0 ; i< Utilities.universidades.size();i++){
                    for (int j = 0 ; j < Utilities.universidades.get(i).getCarreras().size();j++){
                        if(TextUtils.equals("Biologia",Utilities.universidades.get(i).getCarreras().get(j).getArea())){
                            aux.add(Utilities.universidades.get(i).getCarreras().get(j));
                        }
                    }
                }
                break;
        }
        return aux;
    }


    public static ListaCarrerasFragment newInstance(Bundle arguments){
        ListaCarrerasFragment aux = new ListaCarrerasFragment();
        if(arguments != null){
            aux.setArguments(arguments);
        }
        return aux;
    }
}


