/**
 * 
 */
package com.soa.dao;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.Usuario;

/**
 * Capa de acceso a datos
 */
@Repository
public class UsuariosDao {
    
    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Buscar usuario en base a nombre y password.
     * @param usuario
     * @return Usuario en caso de existo y null si no se encuentra
     */
    public Usuario buscarUsuario(Usuario usuario) {        
      
        try {
            Usuario user = 
                    jdbcTemplate.queryForObject(String.format(
                            "select * from usuarios where nombre = '%s' and password = '%s';",
                    usuario.getNombre(),usuario.getPassword()), 
                    new BeanPropertyRowMapper<>(Usuario.class));
            user.setPeliculaSolicitada(usuario.getPeliculaSolicitada());
            return user;
        } catch (EmptyResultDataAccessException e) {
            // Manejo de la excepción si no se encuentra el usuario
            return null;
        }
    }


}
