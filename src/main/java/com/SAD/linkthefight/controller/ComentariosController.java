package com.SAD.linkthefight.controller;
import com.SAD.linkthefight.entity.Comentarios; 
import com.SAD.linkthefight.service.ComentariosService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; 

import java.util.List; // Importamos la clase List para manejar listas

/* Notas para Kevin y que se acuerde 4
 * Creamos el controlador ComentariosController para manejar las peticiones HTTP relacionadas con los comentarios.
 * Este controlador tiene un endpoint para obtener todos los comentarios de un usuario dado su id.
 * El método obtenerComentariosPorIdUsuario recibe el id del usuario como parámetro y llama al servicio ComentariosService para obtener los comentarios.
 * El método devuelve una lista de Comentarios.
 * El endpoint está definido con la anotación @GetMapping y la ruta es /api/comentarios/{idUsuario}.
 * Esto significa que cuando se hace una petición GET a esta ruta, se llamará al método obtenerComentariosPorIdUsuario.
 * El id del usuario se pasa como parte de la URL.
 * Por ejemplo, si el id del usuario es 1, la ruta sería /api/comentarios/1.
 */

@RestController
@RequestMapping("/api/comentarios") // Definimos la ruta base para este controlador
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService; // Inyectamos el servicio ComentariosService

    @GetMapping("/{idUsuario}")
    public List<Comentarios> obtenerComentariosPorIdUsuario(@PathVariable Long idUsuario) {
        return comentariosService.obtenerComentarioPorIdUsuario(idUsuario);
    }
    
}
