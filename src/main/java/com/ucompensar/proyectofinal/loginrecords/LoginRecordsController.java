package com.ucompensar.proyectofinal.loginrecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-records")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginRecordsController {

    @Autowired
    private LoginRecordsService loginRecordsService;

    // 🔹 Obtener todos los registros
    @GetMapping
    public List<LoginRecords> obtenerTodos() {
        return loginRecordsService.obtenerTodos();
    }

    // 🔹 Obtener registros por usuario
    @GetMapping("/usuario/{usuarioId}")
    public List<LoginRecords> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return loginRecordsService.obtenerPorUsuario(usuarioId);
    }

    // 🔹 Registrar un login (uso interno desde el login)
    @PostMapping
    public LoginRecords registrarLogin(@RequestBody LoginRecords login) {
        return loginRecordsService.registrar(login);
    }
}
