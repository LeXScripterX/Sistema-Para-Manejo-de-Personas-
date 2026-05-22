package com.ucompensar.proyectofinal.DetalleActividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleActividadServicio {

    @Autowired
    private DetalleActividadRepositorio detalleActividadRepositorio;

    // Crear detalle
    public DetalleActividad crearDetalle(DetalleActividad detalleActividad) {

        return detalleActividadRepositorio.save(detalleActividad);
    }

    // Obtener todos
    public List<DetalleActividad> obtenerTodosLosDetalles() {

        return detalleActividadRepositorio.findAll();
    }

    // Obtener por ID
    public DetalleActividad obtenerDetallePorId(Long id) {

        Optional<DetalleActividad> detalle = detalleActividadRepositorio.findById(id);

        return detalle.orElse(null);
    }

    // Obtener detalles por actividad
    public List<DetalleActividad> obtenerDetallesPorActividad(Long actividadId) {

        return detalleActividadRepositorio.findByActividadId(actividadId);
    }

    // Actualizar detalle
    public DetalleActividad actualizarDetalle(Long id, DetalleActividad nuevoDetalle) {

        Optional<DetalleActividad> detalleOptional = detalleActividadRepositorio.findById(id);

        if(detalleOptional.isPresent()) {

            DetalleActividad detalle = detalleOptional.get();

            detalle.setDescripcion(nuevoDetalle.getDescripcion());

            return detalleActividadRepositorio.save(detalle);
        }

        return null;
    }

    // Eliminar detalle
    public void eliminarDetalle(Long id) {

        detalleActividadRepositorio.deleteById(id);
    }
}