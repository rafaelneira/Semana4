package com.example.appmacostas.Presentador;

import android.content.Context;

import com.example.appmacostas.vista.IRecyclerViewFragment_Home;
import com.example.appmacostas.model.Mascota;
import com.example.appmacostas.model.ConstructorMascotas;

import java.util.ArrayList;

public class RecyclerViewFragments_HomePresenter implements IRecyclerViewFragment_HomePresenter {


    private IRecyclerViewFragment_Home iRecyclerViewFragment_home;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public RecyclerViewFragments_HomePresenter(IRecyclerViewFragment_Home iRecyclerViewFragment_home, Context context) {
    this.iRecyclerViewFragment_home=iRecyclerViewFragment_home;
    this.context=context;
    obtenerMascotasBseDatos();
    }


    @Override
    public void obtenerMascotasBseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragment_home.inicializarAdaptadorRV(iRecyclerViewFragment_home.crearAdaptador(mascotas));
        iRecyclerViewFragment_home.generarLinearLayoutVertical();
    }
}
