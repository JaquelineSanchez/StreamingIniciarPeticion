/**
 * 
 */
package com.soa.dao;

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
                            "select idusuario,nombre,apellido,password from usuarios where nombre = '%s' and password = '%s';",
                    usuario.getNombre(),usuario.getPassword()), 
                    new BeanPropertyRowMapper<>(Usuario.class));            
            System.out.println(user.getIdusuario());
            return user;
        } catch (EmptyResultDataAccessException e) {
            // Manejo de la excepción si no se encuentra el usuario
            return null;
        }
    }


}
