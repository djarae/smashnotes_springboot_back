package smashnotest_back.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import smashnotest_back.auth.dto.LoginRequestDTO;
import smashnotest_back.auth.dto.LoginResponseDTO;
import smashnotest_back.auth.service.AuthService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * Endpoint de login
     * POST /api/auth/login
     * Body: { "email": "...", "password": "..." }
     * Response: { "token": "...", "email": "...", "rol": "..." }
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        try {
            LoginResponseDTO response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Credenciales inválidas");
            error.put("message", "Email o contraseña incorrectos");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Error en el servidor");
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    /**
     * Endpoint para verificar si el token es válido
     * GET /api/auth/verify
     * Header: Authorization: Bearer {token}
     */
    @GetMapping("/verify")
    public ResponseEntity<?> verifyToken() {
        // Si llegamos aquí, el token es válido (el filtro JWT ya lo verificó)
        Map<String, Object> response = new HashMap<>();
        response.put("valid", true);
        response.put("message", "Token válido");
        return ResponseEntity.ok(response);
    }
}
