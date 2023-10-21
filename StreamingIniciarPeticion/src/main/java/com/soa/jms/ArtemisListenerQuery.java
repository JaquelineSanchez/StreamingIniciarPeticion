/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.UsuariosBusiness;
import com.soa.dto.Respuesta;
import com.soa.dto.Usuario;

/**
 * Class for receiving messages in an artemis queue
 */
@Component
public class ArtemisListenerQuery {
    
    @Autowired
    private UsuariosBusiness business;
    
    @Autowired
    private JmsSender sender;

    @Value("${queue.name.out}")
    private String outQueueName;

    @Value("${queue.name.next}")
    private String nextQueueName;
    
    /**
     * Recibir datos de un usuario para iniciar sesion
     * @param message JSON con nombre, password y pelicula deseada
     */
    @JmsListener(destination = "${queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s", message));        
        Gson gson = new Gson();
        Usuario usuario = gson.fromJson(message, Usuario.class);
        System.out.println(usuario);
        Respuesta respuesta = business.buscarUsuario(usuario);
        String colaSalida;
        if(respuesta.getMessage() == "Ok.") {
            colaSalida = nextQueueName;
        }
        else {
            colaSalida = outQueueName;
        }       
        System.out.println("resultado de la consulta: " + respuesta);
        try {
            sender.sendMessage(respuesta.toString(), colaSalida);
            System.out.println(String.format("Mensaje enviado: %s", 
                    respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }       
        
    }
}
