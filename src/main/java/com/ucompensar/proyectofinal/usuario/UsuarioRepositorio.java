package com.ucompensar.proyectofinal.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);
    
}