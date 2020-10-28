package com.example.appmacostas;

import com.example.appmacostas.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragment_Home {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotaArrayList);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);



}
