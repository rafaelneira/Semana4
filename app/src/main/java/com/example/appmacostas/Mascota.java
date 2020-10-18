package com.example.appmacostas;

public class Mascota {
    private String Nombre;
    private int Raiting;
    private int Foto;
    private boolean Favorito;

    public Mascota(String nombre, int raiting, int foto, boolean favorito) {
        Nombre = nombre;
        Raiting = raiting;
        Foto = foto;
        Favorito = favorito;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getRaiting() {
        return Raiting;
    }

    public void setRaiting(int raiting) {
        Raiting = raiting;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public boolean isFavorito() {
        return Favorito;
    }

    public void setFavorito(boolean favorito) {
        Favorito = favorito;
    }
}
