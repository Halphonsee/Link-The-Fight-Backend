package com.SAD.linkthefight.controller;

import com.SAD.linkthefight.entity.Rol;
import com.SAD.linkthefight.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /* Aqui utilizaba la funcion obtenerRolDeUsuario como string, pero no me funciono, ya que en la consulta del postman me retorna algo similar a esto "com.SAD.linkthefight.entity.Rol@32b9fcce"*/
    @GetMapping("/{idUsuario}/rol") // Puse que el id fuera en al url
    public Rol obtenerRolDeUsuario(@PathVariable Long idUsuario) { 
        return usuarioService.obtenerRolDeUsuario(idUsuario);
    }
    

    // @GetMapping("/rol/{idUsuario}") // Formato para que la id sea directa de la URL utilizando @PathVariable en vez de @RequestParam
    // public Rol obtenerRolDeUsuario(@PathVariable Long idUsuario) { 
    //     return usuarioService.obtenerRolDeUsuario(idUsuario);
    // }
}
