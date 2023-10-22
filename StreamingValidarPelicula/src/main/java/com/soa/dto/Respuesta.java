package com.soa.dto;

import java.util.List;

import com.google.gson.Gson;

/**
 * Clase que modela la información necesaria para la siguiente cola.
 */
public class Respuesta {

    /*Mensaje de respuesta en caso de error*/
    private String message;
    
    /*Peticion aprobada*/
    private Peticion peticion;
    
    /*Id de la pelicula*/
    private Integer idpelicula;

    public void setMessage(String message) {
        this.message = message;
    }
    
    /*Lista de peliculas disponibles*/
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


    public Peticion getPeticion() {
        return peticion;
    }


    public void setPeticion(Peticion peticion) {
        this.peticion = peticion;
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

}
