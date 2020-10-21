package com.example.appmacostas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmacostas.adaptadores.MascotaAdaptador;

import java.util.ArrayList;

public class Activity_Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedinstanceState){
        super.onCreate(savedinstanceState);
        setContentView(R.layout.activity_favoritos);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicilizarListaMascotas();
        inicializarAdaptador();

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicilizarListaMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Pichichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Salchichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Muchichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Tachichen",5, R.drawable.perro1,true));
        mascotas.add(new Mascota("Nichichen",5, R.drawable.perro1,true));

    }

}