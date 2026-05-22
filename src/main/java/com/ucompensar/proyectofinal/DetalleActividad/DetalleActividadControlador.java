package com.ucompensar.proyectofinal.DetalleActividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
@CrossOrigin(origins = "http://localhost:4200")
public class DetalleActividadControlador {

    @Autowired
    private DetalleActividadServicio detalleActividadServicio;

    // Obtener todos
    @GetMapping
    public List<DetalleActividad> obtenerDetalles() {

        return detalleActividadServicio.obtenerTodosLosDetalles();
    }

    // Obtener detalle por ID
    @GetMapping("/{id}")
    public DetalleActividad obtenerDetallePorId(@PathVariable Long id) {

        return detalleActividadServicio.obtenerDetallePorId(id);
    }

    // Obtener detalles por actividad
    @GetMapping("/actividad/{actividadId}")
    public List<DetalleActividad> obtenerDetallesPorActividad(
            @PathVariable Long actividadId
    ) {

        return detalleActividadServicio.obtenerDetallesPorActividad(actividadId);
    }

    // Crear detalle
    @PostMapping
    public DetalleActividad crearDetalle(
            @RequestBody DetalleActividad detalleActividad
    ) {

        return detalleActividadServicio.crearDetalle(detalleActividad);
    }

    // Actualizar detalle
    @PutMapping("/{id}")
    public DetalleActividad actualizarDetalle(
            @PathVariable Long id,
            @RequestBody DetalleActividad detalleActividad
    ) {

        return detalleActividadServicio.actualizarDetalle(id, detalleActividad);
    }

    // Eliminar detalle
    @DeleteMapping("/{id}")
    public void eliminarDetalle(@PathVariable Long id) {

        detalleActividadServicio.eliminarDetalle(id);
    }
}