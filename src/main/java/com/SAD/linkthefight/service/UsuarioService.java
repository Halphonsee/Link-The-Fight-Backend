package com.SAD.linkthefight.service;

import com.SAD.linkthefight.entity.Rol;
import com.SAD.linkthefight.entity.Usuario;
import com.SAD.linkthefight.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService { 

    @Autowired 
    private UsuarioRepository usuarioRepository; 

    /* Aqui Intente obtenerlo como string, pero no me funciono, ya que en la consulta del postman me retorna algo similar a esto "com.SAD.linkthefight.entity.Rol@32b9fcce" */
    public Rol obtenerRolDeUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
        if (usuario != null) {
            return usuario.getRol(); // Aquí se devuelve directamente el rol asociado
        }
        return null;
    } 

    // public Rol obtenerRolDeUsuario(Long idUsuario) {
    //     Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
    //     if (usuario != null) {
    //         return usuario.getRol(); // Aquí se devuelve directamente el rol asociado
    //     }
    //     return null;
    // }
}
