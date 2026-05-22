package com.ucompensar.proyectofinal.usuario;

import com.ucompensar.proyectofinal.roles.RolesClass;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String password;

    // Campo para desactivar usuario
    private Boolean activo = true;

    // RELACIÓN: muchos usuarios pueden tener un rol
    @ManyToOne
    @JoinColumn(name = "rol_id")
    private RolesClass rol;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public RolesClass getRol() {
        return rol;
    }

    public void setRol(RolesClass rol) {
        this.rol = rol;
    }
}