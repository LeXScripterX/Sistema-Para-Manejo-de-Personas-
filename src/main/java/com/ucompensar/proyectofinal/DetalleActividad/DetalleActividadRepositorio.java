package com.ucompensar.proyectofinal.DetalleActividad;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetalleActividadRepositorio extends JpaRepository<DetalleActividad, Long> {

    // Buscar detalles por actividad
    List<DetalleActividad> findByActividadId(Long actividadId);

}