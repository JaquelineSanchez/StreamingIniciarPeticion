/**
 * 
 */
package com.soa.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.UsuariosDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;

/**
 * Clase para 
 * 
 */
@Component
public class UsuariosBusiness {

    /**Objeto de acceso a datos*/
    @Autowired
    private UsuariosDao usuariosDao;
    
    /**
     * Consulta usuarios por login
     * @param usuario
     * @return
     */
    public Respuesta buscarUsuario(Usuario usuario) {
        
        Respuesta respuesta = new Respuesta();
        try {            
            Usuario user = usuariosDao.buscarUsuario(usuario);
            if(user != null)
                respuesta.setMessage("Ok.");
            else
                respuesta.setMessage(String.format("El usuario %s no existe.", 
                        usuario.getNombre()));
            respuesta.setUsuario(user);
        } catch(Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al consultar usuario");                     
        }            
            return respuesta;        
    }
}
