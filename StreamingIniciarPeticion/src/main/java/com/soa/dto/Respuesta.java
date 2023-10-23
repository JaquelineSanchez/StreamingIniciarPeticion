package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta en casos de error*/
    private String message;
    
    /*Id del Usuario que consulta*/
    private Integer idusuario;
    
    /*Numero de tarjeta de credito del usuario*/
    private String numtarjeta;
    
    /*Titulo de pelicula deseada*/
    private String peliculaSolicitada;
    
    /*Tiempo de renta para la pelicula*/
    private Integer tiempo;

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

    public String getPeliculaSolicitada() {
        return peliculaSolicitada;
    }


    public void setPeliculaSolicitada(String peliculaSolicitada) {
        this.peliculaSolicitada = peliculaSolicitada;
    }


    public String getMessage() {
        return message;
    }


    public String getNumtarjeta() {
        return numtarjeta;
    }


    public void setNumtarjeta(String numtarjeta) {
        this.numtarjeta = numtarjeta;
    }


    public Integer getTiempo() {
        return tiempo;
    }


    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

}
