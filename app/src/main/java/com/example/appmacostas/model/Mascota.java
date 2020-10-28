package com.example.appmacostas.model;

public class Mascota {


    private int id;
    private String Nombre;
    private int Foto;
    private int Favorito;

    public Mascota() {
    }

    public Mascota(int id, String nombre, int foto, int favorito) {
        Nombre = nombre;
        Foto = foto;
        Favorito = favorito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavorito() {
        return Favorito;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }



    public void setFavorito(int favorito) {
        Favorito = favorito;
    }
}
