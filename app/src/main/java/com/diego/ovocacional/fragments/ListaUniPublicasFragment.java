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
public class ListaUniPublicasFragment extends Fragment {


    public ListaUniPublicasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista_uni_publicas, container, false);
        return v;
    }



}
