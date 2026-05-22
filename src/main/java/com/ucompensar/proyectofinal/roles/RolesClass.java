package com.ucompensar.proyectofinal.roles;
import com.ucompensar.proyectofinal.usuario.Usuario;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class RolesClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ej: ADMIN, USER

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

}