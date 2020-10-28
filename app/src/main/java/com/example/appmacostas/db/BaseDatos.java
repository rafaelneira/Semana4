package com.example.appmacostas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.appmacostas.model.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.DATABASE_NAME + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE + " INTEGER" +
                ")";

        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_NRO_FAVS + " INTEGER," +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_ID_MASCOTA + ")" +
                "REFERENCES "+ ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaLikes);
        db.execSQL(queryCrearTablaMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas=new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query, null);

        while (registro.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registro.getInt(0));
            mascotaActual.setNombre(registro.getString(1));
            mascotaActual.setFoto(registro.getInt(2));
            mascotaActual.setFavorito(registro.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS_LIKE, null, contentValues);
        db.close();
    }

    public int obtenerlikeMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE_NRO_FAVS +" ) + " +
                 " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS_LIKE +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + " = " + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query, null);
        if (registro.moveToNext()){
            likes = registro.getInt(0);
        }
        db.close();

        return likes;
    }

}
