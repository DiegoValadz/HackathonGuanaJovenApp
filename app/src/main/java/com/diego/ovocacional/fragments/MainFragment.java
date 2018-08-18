package com.diego.ovocacional.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.diego.ovocacional.R;
import com.diego.ovocacional.adapters.MainAdapter;
import com.diego.ovocacional.models.Element;
import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Element> elements;
    private MainAdapter adapter;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        fillElementsList();
        recyclerView = v.findViewById(R.id.main_rv);
        adapter = new MainAdapter(elements, getContext());
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(glm);
        return v;
    }

    private void fillElementsList() {
        elements = new ArrayList<>();
        elements.add(new Element("Temporada 1", "Capitulos: "));
        elements.add(new Element("Programa N°2", "Método de Bisección"));
        elements.add(new Element("Programa N°3", "Método de Jacobi"));
        elements.add(new Element("Programa N°4", "Método de Diferenciación numérica"));
        elements.add(new Element("Programa N°5", "Método trapezoidal"));
        elements.add(new Element("Programa N°6", "Método parabolico (Experimental)"));
        elements.add(new Element("Programa N°7", "Método de LaGrange"));


    }
}
