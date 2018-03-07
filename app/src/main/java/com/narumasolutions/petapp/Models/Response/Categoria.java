package com.narumasolutions.petapp.Models.Response;

import java.io.Serializable;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class Categoria implements Serializable {

    private String id;
    private String nombre;
    private String Imagen;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
