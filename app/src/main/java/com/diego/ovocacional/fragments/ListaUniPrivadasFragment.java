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
public class ListaUniPrivadasFragment extends Fragment {


    public ListaUniPrivadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_uni_privadas, container, false);
    }

}
