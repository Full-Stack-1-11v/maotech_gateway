package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.AuthServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthGatewayController {
    
    @Autowired
    private AuthServiceClient authServiceClient;
    
    @PostMapping("/register")
    public String registerUser(@RequestBody Object user) {
        return authServiceClient.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Object authenticationRequest) {
        return authServiceClient.loginUser(authenticationRequest);
    }

    @GetMapping("/inicio")
    public String hello() {
        return authServiceClient.hello();
    }
}