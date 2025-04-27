package com.SAD.linkthefight.service;

import com.SAD.linkthefight.entity.Rol;
import com.SAD.linkthefight.entity.Usuario;
import com.SAD.linkthefight.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.SAD.linkthefight.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SAD.linkthefight.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Map;
import java.util.HashMap;


@Service
public class UsuarioService {
    private RolRepository rolRepository;
    private UsuarioRepository usuarioRepository;
    private ObjectMapper objectMapper;
    private PasswordEncoder encoder;
    private JwtUtil jwt;
    @Autowired
    // Constructor
    public UsuarioService(UsuarioRepository usuarioRepository, ObjectMapper objectMapper, PasswordEncoder encoder, JwtUtil jwt, RolRepository rolRepository) {
        this.rolRepository = rolRepository;
        this.usuarioRepository = usuarioRepository;
        this.objectMapper = objectMapper;
        this.encoder = encoder;
        this.jwt = jwt;
    }


    /* Aqui una funcion que me permita registrar usuarios mediante postman con un JSON que se transcribe en String */
    public Usuario registrarUsuario(String usuario){
      Usuario newUsuario = new Usuario();
      try {
        JsonNode jsonNode = objectMapper.readTree(usuario);
        newUsuario.setName(jsonNode.get("name").asText());
        newUsuario.setEmail(jsonNode.get("email").asText());
        Long rolId = jsonNode.get("rol").asLong();
        Rol rol = rolRepository.findById(rolId)
                .orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
        newUsuario.setRol(rol);
        newUsuario.setPassword(encoder.encode(jsonNode.get("password").asText()));
        usuarioRepository.save(newUsuario);
        return newUsuario;
        } catch (Exception e) {
              e.printStackTrace();
              return null; 
          }
    }

    public Map<String, String> authenticate(String body) throws Exception {
        try{
            JsonNode usuario = objectMapper.readTree(body);

            Usuario user = usuarioRepository.findByEmail(usuario.get("email").asText());
            if(user == null) {
                throw new RuntimeException("Usuario no encontrado");
            }
            if (!encoder.matches(usuario.get("password").asText(), user.getPassword())) {
                throw new RuntimeException("Credenciales incorrectas");
            }
            String token = jwt.generateToken(user.getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return response;
        }
        catch (RuntimeException e) {
            throw e;
        }
    }
}
