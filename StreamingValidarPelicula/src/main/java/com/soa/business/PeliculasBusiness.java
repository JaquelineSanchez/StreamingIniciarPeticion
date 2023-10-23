/**
 * 
 */
package com.soa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.PeliculasDao;
import com.soa.dto.Pelicula;
import com.soa.dto.Peticion;
import com.soa.dto.Respuesta;

/**
 * Capa de negocio para validar peliculas
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
     * @return id de la pelicula o lista de peliculas disponibles
     */
    public Respuesta validarPelicula(Peticion peticion) {
        
        Respuesta respuesta = new Respuesta();
        try {            
            Pelicula pelicula = 
                    peliculasDao.buscarPelicula(peticion.getPeliculaSolicitada());
            if(pelicula != null) {
                if(peticion.getTiempo() <= pelicula.getDuracion()) {
                    respuesta.setIdpelicula(pelicula.getIdpelicula());
                    respuesta.setIdusuario(peticion.getIdusuario());
                    respuesta.setNumtarjeta(peticion.getNumtarjeta());
                    respuesta.setTiempo(peticion.getTiempo());
                }
                else {
                    respuesta.setMessage(
                            String.format(
                                    "ERROR: La pelicula %s dura %d(s) no puedes rentar %d(s).", 
                            pelicula.getTitulo(),pelicula.getDuracion(),peticion.getTiempo()));
                }
            }else {
                respuesta.setMessage(String.format("La pelicula %s no existe.", 
                        peticion.getPeliculaSolicitada()));
                respuesta.setPeliculasDisponibles(peliculasDao.mostrarCatalogo());
            }
        } catch(Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al consultar usuario");                     
        }            
            return respuesta;        
    }
    
    
}
