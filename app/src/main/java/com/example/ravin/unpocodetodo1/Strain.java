package com.example.ravin.unpocodetodo1;

import java.io.Serializable;

/**
 * Created by ravin on 27/02/2018.
 */

public class Strain implements Serializable{

    private String nombre;
    private String descripcion;
    private int imagen;

    public Strain(String nombre, String descripcion, int imagen){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
