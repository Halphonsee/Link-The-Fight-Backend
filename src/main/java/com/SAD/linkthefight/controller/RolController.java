package com.SAD.linkthefight.controller; // Paquete de la clase RolController

import com.SAD.linkthefight.entity.Rol; // Importamos la entidad Rol
import com.SAD.linkthefight.service.RolService; // Importamos el servicio RolService
import org.springframework.beans.factory.annotation.Autowired; // Importamos la clase Autowired para inyectar dependencias
import org.springframework.web.bind.annotation.*; // Importamos las anotaciones de Spring para crear un controlador REST

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> obtenerRoles() {
        return rolService.obtenerTodosLosRoles();
    }
}
