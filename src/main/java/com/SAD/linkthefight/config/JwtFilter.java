package com.SAD.linkthefight.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import com.SAD.linkthefight.repository.UsuarioRepository;
import com.SAD.linkthefight.entity.Usuario;
import org.springframework.stereotype.Component;

import com.SAD.linkthefight.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired private JwtUtil jwt;
    @Autowired private UsuarioRepository repo;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        try {
            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);
                String email = jwt.validateToken(token);
                UserDetails userDetails = null;
                Usuario user = repo.findByEmail(email);
                if (user != null) {
                    userDetails = new org.springframework.security.core.userdetails.User(
                            user.getEmail(), user.getPassword(), new ArrayList<>());
                }
    
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        } catch (Exception ex) {
            // Si el token es inválido, no autentiques y sigue la cadena
            SecurityContextHolder.clearContext();
        }
        chain.doFilter(request, response);
    }
}
