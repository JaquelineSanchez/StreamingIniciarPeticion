package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta*/
    private String message;
    
    /*Id del Usuario que consulta*/
    private Integer idusuario;
    
    /*Nombre de usuario que consulta*/
    private String nombre;
    
    /*Titulo de pelicula deseada*/
    private String peliculaSolicitada;

    public void setMessage(String message) {
        this.message = message;
    }


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


    public String getMessage() {
        return message;
    }

}
