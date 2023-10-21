package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información de una persona.
 */
public class Usuario {
    
    /*Id del usuario*/
    private Integer id;
    
    /*nombre del usuario*/
    private String nombre;
    
    /*nombre del usuario*/
    private String apellido;
     
    /*Contraseña del usuario*/
    private String password;
    
    /*Pelicula que busca el usuario*/
    private String peliculaSolicitada;
            
    @Override
    public String toString() {
        Gson gson = new Gson();
        //Convierte el objeto de la clase a un json
        String json = gson.toJson(this);
        return json;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPeliculaSolicitada() {
        return peliculaSolicitada;
    }

    public void setPeliculaSolicitada(String peliculaSolicitada) {
        this.peliculaSolicitada = peliculaSolicitada;
    }

   
}