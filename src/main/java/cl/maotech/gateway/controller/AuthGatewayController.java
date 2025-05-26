package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.AuthServiceClient;
import cl.maotech.gateway.client.UserServiceClient;
import cl.maotech.gateway.dto.AuthRequest;
import cl.maotech.gateway.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gateway/auth")
public class AuthGatewayController {
    
    @Autowired
    private AuthServiceClient authServiceClient;
    
    @Autowired
    private UserServiceClient userServiceClient;
    
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            // 1. Registrar en auth-service (esto hashea la contraseña)
            String authResult = authServiceClient.registerUser(user);
            
            // 2. Crear usuario en user-service con contraseña ya hasheada
            // La contraseña ya viene hasheada del auth-service
            ResponseEntity<User> userResult = userServiceClient.createUser(user);
            
            if (userResult.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("Usuario registrado exitosamente en ambos servicios");
            } else {
                return ResponseEntity.badRequest().body("Error al crear usuario en user-service");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en el registro: " + e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        try {
            String token = authServiceClient.loginUser(authRequest);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error en login: " + e.getMessage());
        }
    }
    
    @GetMapping("/hello")
    public String hello() {
        return authServiceClient.hello();
    }
}