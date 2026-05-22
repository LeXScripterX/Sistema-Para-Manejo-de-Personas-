package com.ucompensar.proyectofinal.usuario;

import org.springframework.http.ResponseEntity;
import com.ucompensar.proyectofinal.jwt.AuthResponse;
import com.ucompensar.proyectofinal.loginrecords.*;
import com.ucompensar.proyectofinal.roles.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class LogInControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private LoginRecordsService loginRecordsService;

    @Autowired
    private RolesServicio rolesservicio;


    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario) {

        return usuarioServicio.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {

        Usuario user = usuarioServicio.login(
                usuario.getCorreo(),
                usuario.getPassword()
        );

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }

        if (!user.getActivo())
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
        // 🔥 2. Registrar login en auditoría
        LoginRecords record = new LoginRecords();
        record.setUsuario(user);
        record.setFechaLogin(java.time.LocalDateTime.now());
        record.setIp("UNKNOWN"); // luego lo mejoramos
        record.setStatus("Login");

        loginRecordsService.registrar(record);
        String token = jwtService.generateToken(user.getCorreo());

        return ResponseEntity.ok(new AuthResponse(token, user.getRol().getNombre(), user.getNombre()));
    }
}