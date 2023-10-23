package com.soa.dto;

import java.util.List;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta en caso de error*/
    private String message;
    
    /*Id del usuario*/
    private Integer idusuario;
    
    /*Id de la pelicula*/
    private Integer idpelicula;
    
    /*Tiempo de renta de la pelicula*/
    private Integer tiempo;
    
    /*Numero de tarjeta de credito del usuario*/
    private String numtarjeta;

    public void setMessage(String message) {
        this.message = message;
    }
    
    /*Lista de peliculas disponibles en caso de error*/
    private List<Pelicula> peliculasDisponibles;

    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }

    public Integer getIdpelicula() {
        return idpelicula;
    }


    public void setIdpelicula(Integer idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getMessage() {
        return message;
    }

    public List<Pelicula> getPeliculasDisponibles() {
        return peliculasDisponibles;
    }

    public void setPeliculasDisponibles(List<Pelicula> peliculasDisponibles) {
        this.peliculasDisponibles = peliculasDisponibles;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getNumtarjeta() {
        return numtarjeta;
    }

    public void setNumtarjeta(String numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

}
