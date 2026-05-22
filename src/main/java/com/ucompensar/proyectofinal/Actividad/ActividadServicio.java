package com.ucompensar.proyectofinal.Actividad;

import com.ucompensar.proyectofinal.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServicio {

    @Autowired
    private ActividadRepositorio actividadRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    // Crear actividad
    public Actividad crearActividad(Actividad actividad) {

        // Buscar creador desde BD
        Usuario creador = usuarioRepositorio
                .findById(actividad.getCreador().getId().intValue())
                .orElse(null);

        if (creador == null) {
            throw new RuntimeException("Usuario creador no existe");
        }

        // Validar rol
        if (creador.getRol().getNombre().equalsIgnoreCase("AGENTE")) {
            throw new RuntimeException("Los agentes no pueden crear actividades");
        }

        // Asignar creador completo
        actividad.setCreador(creador);

        // Buscar responsable
        if (actividad.getResponsable() != null) {

            Usuario responsable = usuarioRepositorio
                    .findById(actividad.getResponsable().getId().intValue())
                    .orElse(null);

            actividad.setResponsable(responsable);

            actividad.setEstado("ASIGNADO");

        } else {

            actividad.setEstado("SIN_ASIGNAR");
        }

        // Asociar detalles
        if (actividad.getDetalles() != null) {

            actividad.getDetalles().forEach(detalle -> {
                detalle.setActividad(actividad);
            });
        }

        return actividadRepositorio.save(actividad);
    }

    // Obtener todas
    public List<Actividad> obtenerTodasLasActividades() {
        return actividadRepositorio.findAll();
    }

    // Obtener por ID
    public Actividad obtenerActividadPorId(Long id) {

        Optional<Actividad> actividad = actividadRepositorio.findById(id);

        return actividad.orElse(null);
    }

    // Eliminar
    public void eliminarActividad(Long id) {
        actividadRepositorio.deleteById(id);
    }

    // Actualizar estado
    public Actividad actualizarEstado(Long id, String estado) {

        Optional<Actividad> actividadOptional = actividadRepositorio.findById(id);

        if (actividadOptional.isPresent()) {

            Actividad actividad = actividadOptional.get();

            actividad.setEstado(estado);

            return actividadRepositorio.save(actividad);
        }

        return null;
    }

    // Asignar responsable
    public Actividad asignarResponsable(Long id, Usuario responsable) {

        Optional<Actividad> actividadOptional = actividadRepositorio.findById(id);

        if (actividadOptional.isPresent()) {

            Actividad actividad = actividadOptional.get();

            actividad.setResponsable(responsable);

            actividad.setEstado("ASIGNADO");

            return actividadRepositorio.save(actividad);
        }

        return null;
    }
}