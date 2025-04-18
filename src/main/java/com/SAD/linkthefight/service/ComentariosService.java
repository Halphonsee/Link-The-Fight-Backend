package com.SAD.linkthefight.service;
import com.SAD.linkthefight.entity.Comentarios;
import com.SAD.linkthefight.repository.ComentariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    /* Notas para Kevin y que se acuerde 3
    * Creamos el servicio ComentariosService para manejar la lógica de negocio relacionada con los comentarios.
    * Este servicio tiene un método para obtener todos los comentarios de un usuario dado su id.
    * El método obtenerComentarioPorIdUsuario recibe el id del usuario como parámetro y llama al repositorio ComentariosRepository para obtener los comentarios.
    * El método devuelve una lista de Comentarios.
    * Esto nos permitirá mostrar todos los comentarios de un usuario en la interfaz de usuario.
    * Luego pasamos a crear un controlador para manejar las peticiones HTTP relacionadas con los comentarios.
    */


@Service
public class ComentariosService {
    @Autowired

    private ComentariosRepository comentariosRepository;
    
    public List<Comentarios> obtenerComentarioPorIdUsuario(Long idUsuario) {
        return comentariosRepository.findByUsuarioId(idUsuario);
    }
}
