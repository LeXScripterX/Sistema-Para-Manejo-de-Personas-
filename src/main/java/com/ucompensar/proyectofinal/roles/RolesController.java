package com.ucompensar.proyectofinal.roles;

import com.ucompensar.proyectofinal.usuario.Usuario;
import com.ucompensar.proyectofinal.usuario.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolesController {

    @Autowired
    private RolesServicio rolesservicio;

    // Obtener todos
    @GetMapping
    public List<RolesClass> obtenerUsuarios() {
        return rolesservicio.obtenerTodosRoles();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public RolesClass obtenerUsuarioPorId(@PathVariable Integer id) {
        return rolesservicio.obtenerRolPorId(id);
    }

    // Crear usuario
    @PostMapping
    public RolesClass crearUsuario(@RequestBody RolesClass rol) {
        return rolesservicio.registrarRol(rol);
    }

    // Eliminar totalmente
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        rolesservicio.eliminarUsuario(id);
    }

}
