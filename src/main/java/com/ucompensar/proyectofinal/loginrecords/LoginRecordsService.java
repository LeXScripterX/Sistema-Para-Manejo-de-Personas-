package com.ucompensar.proyectofinal.loginrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoginRecordsService {

    @Autowired
    private LoginRecordsRepository repository;

    public List<LoginRecords> obtenerTodos() {
        return repository.findAll();
    }

    public List<LoginRecords> obtenerPorUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public LoginRecords registrar(LoginRecords login) {
        login.setFechaLogin(LocalDateTime.now());
        return repository.save(login);
    }
}
