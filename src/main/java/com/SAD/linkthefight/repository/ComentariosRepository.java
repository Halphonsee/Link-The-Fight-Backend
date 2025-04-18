package com.SAD.linkthefight.repository;
import com.SAD.linkthefight.entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

    /* Notas para Kevin y que se acuerde 2
    * Creamos el repositorio ComentariosRepository para manejar los comentarios en la base de datos.
    * Este repositorio extiende JpaRepository, lo que nos da acceso a métodos CRUD y de consulta.
    * Además, definimos un método para encontrar comentarios por el id del usuario.
    * Esto nos permitirá obtener todos los comentarios de un usuario específico.
    * El método findByUsuarioId(Long idUsuario) busca todos los comentarios de un usuario dado su id.
    * Esto es útil para mostrar todos los comentarios de un usuario en la interfaz de usuario.
    * El método devuelve una lista de Comentarios.
    * Luego pasamos a crear un servicio para manejar la lógica de negocio relacionada con los comentarios.
    */

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, Long> {
    List<Comentarios> findByUsuarioId(Long idUsuario);

}
