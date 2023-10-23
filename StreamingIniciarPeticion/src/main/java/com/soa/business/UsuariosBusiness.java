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
     * @param peticion recibida
     * @return mensaje de error o 
     * json con idusuario,pelicula, tiempo y numtarjeta
     */
    public Respuesta buscarUsuario(Usuario usuario) {
        
        Respuesta respuesta = new Respuesta();
        try {            
            Usuario user = usuariosDao.buscarUsuario(usuario);
            if(user != null)
            {
                System.out.println(
                        String.format(
                                "Inicio de sesión exitoso, Bienvenid@: %s %s", 
                                user.getNombre(),user.getApellido()));
                respuesta.setIdusuario(user.getIdusuario());
                respuesta.setNumtarjeta(usuario.getNumtarjeta());                
                respuesta.setPeliculaSolicitada(usuario.getPeliculaSolicitada());
                respuesta.setTiempo(usuario.getTiempo());
                
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
