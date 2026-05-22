package com.ucompensar.proyectofinal.Actividad;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ucompensar.proyectofinal.DetalleActividad.DetalleActividad;
import com.ucompensar.proyectofinal.usuario.Usuario;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String titulo;

    private String estado;

    // Usuario que crea la actividad
    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;

    // Usuario responsable (opcional)
    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Usuario responsable;

    // Relación con detalles
    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleActividad> detalles;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public List<DetalleActividad> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleActividad> detalles) {
        this.detalles = detalles;
    }
}