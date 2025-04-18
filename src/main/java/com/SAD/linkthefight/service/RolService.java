package com.SAD.linkthefight.service; // Paquete de la clase RolService

import com.SAD.linkthefight.entity.Rol; // llamamos la ebtidad Rol
import com.SAD.linkthefight.repository.RolRepository; // llamamos el repositorio RolRepository
import org.springframework.beans.factory.annotation.Autowired; // Importamos la clase Autowired para inyectar dependencias
import org.springframework.stereotype.Service; // Importamos la clase Service para indicar que es un servicio
import java.util.List; // Importamos la clase List para manejar listas

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }
}
