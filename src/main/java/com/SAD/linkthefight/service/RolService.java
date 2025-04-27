package com.SAD.linkthefight.service; // Paquete de la clase RolService
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.SAD.linkthefight.entity.Rol; // llamamos la ebtidad Rol
import com.SAD.linkthefight.repository.RolRepository; // llamamos el repositorio RolRepository
import org.springframework.beans.factory.annotation.Autowired; // Importamos la clase Autowired para inyectar dependencias
import org.springframework.stereotype.Service; // Importamos la clase Service para indicar que es un servicio
import java.util.List; // Importamos la clase List para manejar listas

@Service
public class RolService {
    
    private final RolRepository rolRepository;
    private final ObjectMapper objectMapper;
    
    @Autowired
    public RolService(RolRepository rolRepository, ObjectMapper objectMapper) {
        this.rolRepository = rolRepository;
        this.objectMapper = objectMapper;
    }

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Rol crearRol(String rol) {
        Rol newRol = new Rol();
        try {
            System.out.println("JSON recibido: " + rol); // Log para depuración
            JsonNode jsonNode = objectMapper.readTree(rol);
            newRol.setName(jsonNode.get("name").asText());
            
            // Verifica si el campo tier existe antes de intentar acceder
            if (jsonNode.has("tier")) {
                newRol.setTier(jsonNode.get("tier").asInt());
            }
            
            System.out.println("Guardando rol: " + newRol.getName());
            return rolRepository.save(newRol);
        } catch (Exception e) {
            System.err.println("Error al crear rol: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error al crear rol: " + e.getMessage());
        }
    }
}
