package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la información de una peticion para rentar pelicula.
 */
public class Usuario {
    
    /*Id del usuario*/
    private Integer idusuario;
    
    /*nombre del usuario*/
    private String nombre;
    
    /*Apellido del usuario*/
    private String apellido;
     
    /*Contraseña del usuario*/
    private String password;
    
    /*Pelicula que busca el usuario*/
    private String peliculaSolicitada;
    
    /*Tiempo de renta que solicita el usuario*/
    private Integer tiempo;
    
    /*Numero de la tarjeta de credito del usuario*/
    private String numtarjeta;
            
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

    public void setIdusuario(Integer id) {
        this.idusuario = id;
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
