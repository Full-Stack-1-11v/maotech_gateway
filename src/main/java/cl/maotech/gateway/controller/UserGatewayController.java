package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserGatewayController {
    
    @Autowired
    private UserServiceClient userServiceClient;
    
    // User endpoints
    @PostMapping("/create")
    public ResponseEntity<Object> createUser(@RequestBody Object user) {
        return userServiceClient.createUser(user);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Object>> listUsersAsDto() {
        return userServiceClient.listUsersAsDto();
    }

    @GetMapping("/list/admin")
    public ResponseEntity<List<Object>> listUsers() {
        return userServiceClient.listUsers();
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<Object> findUserByDTO(@PathVariable Integer id) {
        return userServiceClient.findUserByDTO(id);
    }

    @GetMapping("/{id}/details/admin")
    public ResponseEntity<Object> findUserById(@PathVariable Integer id) {
        return userServiceClient.findUserById(id);
    }

    @PutMapping("/{id}/full-update")
    public ResponseEntity<Object> fullUpdateUser(@PathVariable Integer id, @RequestBody Object user) {
        return userServiceClient.fullUpdateUser(id, user);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody Object editDTO) {
        return userServiceClient.updateUser(id, editDTO);
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Object> deactivateUser(@PathVariable Integer id, @RequestBody Object statusDTO) {
        return userServiceClient.deactivateUser(id, statusDTO);
    }

    @PutMapping("/{id}/role/edit")
    public ResponseEntity<Object> updateUserRole(@PathVariable Integer id, @RequestBody Object roleDTO) {
        return userServiceClient.updateUserRole(id, roleDTO);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        return userServiceClient.deleteUser(id);
    }

    @GetMapping("/inactives/admin")
    public ResponseEntity<List<Object>> findInactiveUsers() {
        return userServiceClient.findInactiveUsers();
    }

    @GetMapping("/inactives")
    public ResponseEntity<List<Object>> findInactiveUsersDto() {
        return userServiceClient.findInactiveUsersDto();
    }

    @DeleteMapping("/inactives/delete")
    public ResponseEntity<?> deleteAllInactiveUsers() {
        return userServiceClient.deleteAllInactiveUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Object user) {
        return userServiceClient.loginUser(user);
    }

    // Role endpoints
    @PostMapping("/roles/create")
    public ResponseEntity<Object> createRole(@RequestBody Object role) {
        return userServiceClient.createRole(role);
    }

    @GetMapping("/roles/list")
    public ResponseEntity<List<Object>> listRoles() {
        return userServiceClient.listRoles();
    }

    @GetMapping("/roles/{id}/details")
    public ResponseEntity<Object> findRoleById(@PathVariable Integer id) {
        return userServiceClient.findRoleById(id);
    }

    @DeleteMapping("/roles/{id}/delete")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id) {
        return userServiceClient.deleteRole(id);
    }
}