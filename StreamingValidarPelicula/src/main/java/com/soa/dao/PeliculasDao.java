/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Pelicula;


/**
 * Capa de acceso a datos
 */
@Repository
public class PeliculasDao {
    
    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Buscar pelicula en base a titulo
     * @param titulo a buscar
     * @return Pelicula en caso de exito y null si no se encuentra
     */
    public Pelicula buscarPelicula(String titulo) {        
      
        try {
            Pelicula pelicula = 
                    jdbcTemplate.queryForObject(String.format(
                            "select idpelicula,titulo,duracion from peliculas where titulo = '%s';",
                    titulo), 
                    new BeanPropertyRowMapper<>(Pelicula.class));            
            return pelicula;
        } catch (EmptyResultDataAccessException e) {
            // Manejo de la excepción si no se encuentra la pelicula
            return null;
        }
    }
    
    /**
     * Consultar todas las peliculas disponibles
     * @return Lista de Peliculas 
     */
    public List<Pelicula> mostrarCatalogo() {
        List<Pelicula> disponibles  = new ArrayList<>();
        List<Map<String, Object>> lista = jdbcTemplate.queryForList(
                "select titulo, duracion, anio, genero from peliculas;");                        
        for (Map<String, Object> registro : lista) {
            Pelicula peli = new Pelicula();            
            peli.setTitulo((String)registro.get("titulo"));
            peli.setDuracion((Integer)registro.get("duracion"));
            peli.setAnio((Integer)registro.get("anio"));
            peli.setGenero((Integer)registro.get("genero"));
            disponibles.add(peli);
        }
        return disponibles;
    }


}
