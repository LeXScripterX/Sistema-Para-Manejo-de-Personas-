package com.ucompensar.proyectofinal.DetalleActividad;

import com.ucompensar.proyectofinal.Actividad.Actividad;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name = "detalle_actividad")
public class DetalleActividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    // Relación muchos detalles a una actividad
    @ManyToOne
    @JoinColumn(name = "actividad_id", nullable = false)
    @JsonBackReference
    private Actividad actividad;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}