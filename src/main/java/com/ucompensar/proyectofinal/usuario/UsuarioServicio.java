package com.ucompensar.proyectofinal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Registrar usuario
    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    // Obtener todos
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepositorio.findAll();
    }

    // Buscar por ID
    public Usuario obtenerUsuarioPorId(Integer id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    // Login
    public Usuario login(String correo, String password) {

        Optional<Usuario> usuario = usuarioRepositorio.findByCorreo(correo);

        if(usuario.isPresent()) {

            if(usuario.get().getPassword().equals(password)) {
                return usuario.get();
            }

        }

        return null;
    }

    // Eliminar totalmente
    public void eliminarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }

    // Desactivar usuario
    public Usuario desactivarUsuario(Integer id) {

        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);

        if(usuarioOptional.isPresent()) {

            Usuario usuario = usuarioOptional.get();

            usuario.setActivo(false);

            return usuarioRepositorio.save(usuario);
        }

        return null;
    }
}