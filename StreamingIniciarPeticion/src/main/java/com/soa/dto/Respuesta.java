package com.soa.dto;

import java.util.List;

import com.google.gson.Gson;

/**
 * Clase que modela la información resumida de una persona.
 */
public class Respuesta {

    /*Mensaje de respuesta*/
    private String message;
    
    /*Lista de usuarios*/
    private Usuario usuario;

        
    public String getMessage() {
        return message;
    }


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


    public Usuario getUsuario() {
        return usuario;
    }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
