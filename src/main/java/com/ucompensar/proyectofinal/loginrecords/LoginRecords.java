package com.ucompensar.proyectofinal.loginrecords;

import com.ucompensar.proyectofinal.usuario.Usuario;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "loginrecords")
public class LoginRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario que inició sesión
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Fecha y hora del login
    private LocalDateTime fechaLogin;

    // IP desde donde se conectó (opcional pero útil)
    private String ip;
    private String Status;

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaLogin(LocalDateTime fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
