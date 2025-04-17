package com.SAD.linkthefight.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SAD.linkthefight.entity.Usuario;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping
    public String crear() {
        return "Hola mundoo";
    }
    
}
