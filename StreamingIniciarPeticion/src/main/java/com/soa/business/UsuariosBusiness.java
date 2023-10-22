/**
 * 
 */
package com.soa.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.UsuariosDao;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;

/**
 * Capa de negocio que consulta usuarios
 * 
 */
@Component
public class UsuariosBusiness {

    /**Objeto de acceso a datos*/
    @Autowired
    private UsuariosDao usuariosDao;
    
    /**
     * Consulta usuario por nombre y contraseña
     * @param usuario
     * @return
     */
    public Respuesta buscarUsuario(Usuario usuario) {
        
        Respuesta respuesta = new Respuesta();
        try {            
            Usuario user = usuariosDao.buscarUsuario(usuario);
            if(user != null)
            {
                respuesta.setIdusuario(user.getIdusuario());
                respuesta.setNombre(user.getNombre());
                respuesta.setPeliculaSolicitada(usuario.getPeliculaSolicitada());
                
            }else
                respuesta.setMessage(String.format("El usuario %s no existe.", 
                        usuario.getNombre()));            
        } catch(Exception e) {
            e.printStackTrace();
            respuesta.setMessage("Error en la BD al consultar usuario");                     
        }            
            return respuesta;        
    }
}
