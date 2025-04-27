package com.SAD.linkthefight.controller;
import java.util.Map;
import com.SAD.linkthefight.entity.Usuario;
import com.SAD.linkthefight.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> crear(@RequestBody String requestBody){
      try {
        Usuario response = usuarioService.registrarUsuario(requestBody);
        return ResponseEntity.ok(response);
      }catch (Exception e) {
        return ResponseEntity.badRequest().body("Error al registrar el usuario: " + e.getMessage());
      }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String requestBody) {
        try {
            Map<String, String> response = usuarioService.authenticate(requestBody);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Error al autenticar el usuario: " + e.getMessage());
        }
    }


  }
