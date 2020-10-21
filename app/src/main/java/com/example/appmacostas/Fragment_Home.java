package com.example.appmacostas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmacostas.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

public class Fragment_Home extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvMascotas = view.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicilizarListaMascotas();
        inicializarAdaptador();

        return view;
    }

    public void inicilizarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Pichichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Salchichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Muchichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Tachichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Nichichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Puchichen",5, R.drawable.perro1,false));
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas);
        rvMascotas.setAdapter(adaptador);
    }
}
