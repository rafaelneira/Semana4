package com.example.appmacostas.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmacostas.Presentador.IRecyclerViewFragment_HomePresenter;
import com.example.appmacostas.Presentador.RecyclerViewFragments_HomePresenter;
import com.example.appmacostas.R;
import com.example.appmacostas.adaptadores.MascotaAdaptador;
import com.example.appmacostas.model.Mascota;

import java.util.ArrayList;

public class Fragment_Home extends Fragment implements IRecyclerViewFragment_Home{

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    private RecyclerView rvMascotas;
    private IRecyclerViewFragment_HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvMascotas = view.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragments_HomePresenter(this,getContext());
        return view;
    }




    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotaArrayList) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
