package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información recibida del json.
 */
public class Peticion {
    
    /*Id del Usuario que solicita el servicio*/
    private Integer idusuario;
    
    /*Nombre de Usuario solicitante*/
    private String nombre;
    
    /*Titulo de la pelicula deseada*/
    private String peliculaSolicitada;


    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }


    public Integer getIdusuario() {
        return idusuario;
    }


    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPeliculaSolicitada() {
        return peliculaSolicitada;
    }


    public void setPeliculaSolicitada(String peliculaSolicitada) {
        this.peliculaSolicitada = peliculaSolicitada;
    }

}
