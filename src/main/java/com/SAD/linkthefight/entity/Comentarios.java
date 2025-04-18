package com.SAD.linkthefight.entity;

import jakarta.persistence.*;

    /* Notas para Kevin y que se acuerde
    * Creamos la entidad Comentarios para representar los comentarios de los usuarios.
    * La clase Comentarios tiene un id, un texto y una relación con la entidad Usuario.
    * Luego pasamos a crear un repositorio para manejar los comentarios en la base de datos.
    */

@Entity
public class Comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario; // <- ¡Este nombre es más representativo!

    // Getters y Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
