package cl.maotech.gateway.client;

import cl.maotech.gateway.dto.AuthRequest;
import cl.maotech.gateway.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "${microservices.auth-service.url}")
public interface AuthServiceClient {
    
    @PostMapping("/api/register")
    String registerUser(@RequestBody User user);
    
    @PostMapping("/api/login")
    String loginUser(@RequestBody AuthRequest authRequest);
    
    @GetMapping("/api/hello")
    String hello();
}