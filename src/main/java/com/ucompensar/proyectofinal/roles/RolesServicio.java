package com.ucompensar.proyectofinal.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServicio {

    @Autowired
    private RolesRepositorio rolesrespositorio;

    // Crear un nuevo rol
    public RolesClass registrarRol(RolesClass rol) {
        return rolesrespositorio.save(rol);
    }

    // Obtener todos
    public List<RolesClass> obtenerTodosRoles() {
        return rolesrespositorio.findAll();
    }

    // Buscar por ID
    public RolesClass obtenerRolPorId(Integer id) {
        return rolesrespositorio.findById((long)id).orElse(null);
    }


    // Eliminar totalmente
    public void eliminarUsuario(Long id) {
        rolesrespositorio.deleteById(id);
    }

}
