package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "auth-service", url = "${microservices.auth-service.url}")
public interface AuthServiceClient {

    @PostMapping("/api/register")
    String registerUser(@RequestBody Object user);

    @PostMapping("/api/login")
    String loginUser(@RequestBody Object authenticationRequest);

    @GetMapping("/api/inicio")
    String hello();
}