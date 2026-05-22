package com.ucompensar.proyectofinal.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // Obtener todos
    @GetMapping
    public List<Usuario> obtenerUsuarios() {
        return usuarioServicio.obtenerTodosLosUsuarios();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Integer id) {
        return usuarioServicio.obtenerUsuarioPorId(id);
    }

    // Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.registrarUsuario(usuario);
    }

    // Eliminar totalmente
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioServicio.eliminarUsuario(id);
    }

    // Desactivar usuario
    @PutMapping("/desactivar/{id}")
    public Usuario desactivarUsuario(@PathVariable Integer id) {
        return usuarioServicio.desactivarUsuario(id);
    }
}