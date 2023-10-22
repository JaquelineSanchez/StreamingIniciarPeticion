/**
 * 
 */
package com.soa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.PeliculasDao;
import com.soa.dto.Pelicula;
import com.soa.dto.Respuesta;

/**
 * Clase de negocio para validar pelicula
 * 
 */
@Component
public class PeliculasBusiness {

    /**Objeto de acceso a datos*/
    @Autowired
    private PeliculasDao peliculasDao;
        
    /**
     * Validar que exista la pelicula en la BD
     * @param titulo a consultar
     * @return mensaje de exito o lista de peliculas disponibles
     */
    public Respuesta validarPelicula(String titulo) {
        
        Respuesta respuesta = new Respuesta();
        try {            
            Pelicula pelicula = peliculasDao.buscarPelicula(titulo);
            if(pelicula != null) {                
                respuesta.setIdpelicula(pelicula.getIpelicula());                
            }else {
                respuesta.setMessage(String.format("La pelicula %s no existe.", 
                        titulo));
                respuesta.setPeliculasDisponibles(peliculasDao.mostrarCatalogo());
            }
        } catch(Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al consultar usuario");                     
        }            
            return respuesta;        
    }
    
    
}
