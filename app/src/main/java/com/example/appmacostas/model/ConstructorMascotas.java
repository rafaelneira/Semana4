package com.example.appmacostas.model;

import android.content.ContentValues;
import android.content.Context;

import com.example.appmacostas.R;
import com.example.appmacostas.db.BaseDatos;
import com.example.appmacostas.db.ConstantesBaseDatos;

import java.util.ArrayList;

public class ConstructorMascotas {
//clase equivalente a iterador en C#

    private Context context;
    private static final int Like = 1;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

/*
       ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota(1,"Pichichen",R.drawable.perro1,5));
        mascotas.add(new Mascota(2, "Salchichen",R.drawable.perro1, 1));
        mascotas.add(new Mascota(3, "Muchichen",R.drawable.perro1, 3));
        mascotas.add(new Mascota(4,"Tachichen",R.drawable.perro1,2));
        mascotas.add(new Mascota(5,"Nichichen",R.drawable.perro1,1));
        mascotas.add(new Mascota(6,"Puchichen",R.drawable.perro1,5));

        return mascotas;
*/
         BaseDatos db = new BaseDatos(context);
         insertarMascota(db);
         return db.obtenerMascotas();
    }

    public void insertarMascota (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pichichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 5);

        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Salchichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 5);

        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Muchichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 5);

        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Tachichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 5);

        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Nichichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 5);

        db.insertarMascota(contentValues);


        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Puchichen");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, 1);

        db.insertarMascota(contentValues);
    }

    public void likeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_NRO_FAVS, Like);
        db.insertarLikeMascota(contentValues);
    }

    public int obtenerlikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerlikeMascota(mascota);
    }
}
