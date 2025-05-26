package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.UserServiceClient;
import cl.maotech.gateway.dto.User;
import cl.maotech.gateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway/users")
public class UserGatewayController {
    
    @Autowired
    private UserServiceClient userServiceClient;
    
    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return userServiceClient.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        return userServiceClient.getUserById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        return userServiceClient.updateUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return userServiceClient.deleteUser(id);
    }
    
    @GetMapping("/inactives")
    public ResponseEntity<List<UserDTO>> getInactiveUsers() {
        return userServiceClient.getInactiveUsers();
    }
}