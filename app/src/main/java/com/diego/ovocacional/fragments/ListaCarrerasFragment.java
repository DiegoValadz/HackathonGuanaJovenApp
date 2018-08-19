package com.diego.ovocacional.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diego.ovocacional.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaCarrerasFragment extends Fragment {


    public ListaCarrerasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_lista_carreras, container, false);




       return v;
    }


    public static ListaCarrerasFragment newInstance(Bundle arguments){
        ListaCarrerasFragment aux = new ListaCarrerasFragment();
        if(arguments != null){
            aux.setArguments(arguments);
        }
        return aux;
    }
}


