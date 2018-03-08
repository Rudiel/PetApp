package com.narumasolutions.petapp.Models.Response;

import java.io.Serializable;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Taxi implements Serializable {

    private String nombre;
    private String telefono;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
