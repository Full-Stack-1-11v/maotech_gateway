package cl.maotech.gateway.client;

import cl.maotech.gateway.dto.User;
import cl.maotech.gateway.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "${microservices.user-service.url}")
public interface UserServiceClient {
    
    @PostMapping("/api/v1/users/create")
    ResponseEntity<User> createUser(@RequestBody User user);
    
    @GetMapping("/api/v1/users/list")
    ResponseEntity<List<UserDTO>> getAllUsers();
    
    @GetMapping("/api/v1/users/{id}/details")
    ResponseEntity<UserDTO> getUserById(@PathVariable Integer id);
    
    @PutMapping("/api/v1/users/{id}/update")
    ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user);
    
    @DeleteMapping("/api/v1/users/{id}/delete")
    ResponseEntity<?> deleteUser(@PathVariable Integer id);
    
    @GetMapping("/api/v1/users/inactives")
    ResponseEntity<List<UserDTO>> getInactiveUsers();
    
    @PostMapping("/api/v1/users/login")
    ResponseEntity<String> loginUser(@RequestBody User user);
}