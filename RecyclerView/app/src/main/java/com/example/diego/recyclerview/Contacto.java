package com.example.diego.recyclerview;

/**
 * Created by Diego on 17/05/2017.
 */

public class Contacto {

    private String nombre;
    private String telefono;
    private int foto;
    private int likes;
    private int id;

    public Contacto(String nombre, String telefono, int foto, int likes) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.foto = foto;
        this.likes = likes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
