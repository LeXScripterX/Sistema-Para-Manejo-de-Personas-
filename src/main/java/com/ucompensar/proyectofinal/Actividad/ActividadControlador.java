package com.ucompensar.proyectofinal.Actividad;

import com.ucompensar.proyectofinal.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actividades")
@CrossOrigin(origins = "http://localhost:4200")
public class ActividadControlador {

    @Autowired
    private ActividadServicio actividadServicio;

    // Obtener todas
    @GetMapping
    public List<Actividad> obtenerActividades() {
        return actividadServicio.obtenerTodasLasActividades();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Actividad obtenerActividadPorId(@PathVariable Long id) {
        return actividadServicio.obtenerActividadPorId(id);
    }

    // Crear actividad
    @PostMapping
    public Actividad crearActividad(@RequestBody Actividad actividad) {
        return actividadServicio.crearActividad(actividad);
    }

    // Eliminar actividad
    @DeleteMapping("/{id}")
    public void eliminarActividad(@PathVariable Long id) {
        actividadServicio.eliminarActividad(id);
    }

    // Actualizar estado
    @PutMapping("/estado/{id}")
    public Actividad actualizarEstado(
            @PathVariable Long id,
            @RequestParam String estado
    ) {
        return actividadServicio.actualizarEstado(id, estado);
    }

    // Asignar responsable
    @PutMapping("/asignar/{id}")
    public Actividad asignarResponsable(
            @PathVariable Long id,
            @RequestBody Usuario responsable
    ) {
        return actividadServicio.asignarResponsable(id, responsable);
    }
}