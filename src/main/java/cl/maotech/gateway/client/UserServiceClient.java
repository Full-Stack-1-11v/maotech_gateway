package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "${microservices.user-service.url}")
public interface UserServiceClient {

    // User endpoints
    @PostMapping("/api/v1/users/create")
    ResponseEntity<Object> createUser(@RequestBody Object user);

    @GetMapping("/api/v1/users/list")
    ResponseEntity<List<Object>> listUsersAsDto();

    @GetMapping("/api/v1/users/list/admin")
    ResponseEntity<List<Object>> listUsers();

    @GetMapping("/api/v1/users/{id}/details")
    ResponseEntity<Object> findUserByDTO(@PathVariable Integer id);

    @GetMapping("/api/v1/users/{id}/details/admin")
    ResponseEntity<Object> findUserById(@PathVariable Integer id);

    @PutMapping("/api/v1/users/{id}/full-update")
    ResponseEntity<Object> fullUpdateUser(@PathVariable Integer id, @RequestBody Object user);

    @PutMapping("/api/v1/users/{id}/update")
    ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody Object editDTO);

    @PutMapping("/api/v1/users/{id}/deactivate")
    ResponseEntity<Object> deactivateUser(@PathVariable Integer id, @RequestBody Object statusDTO);

    @PutMapping("/api/v1/users/{id}/role/edit")
    ResponseEntity<Object> updateUserRole(@PathVariable Integer id, @RequestBody Object roleDTO);

    @DeleteMapping("/api/v1/users/{id}/delete")
    ResponseEntity<?> deleteUser(@PathVariable Integer id);

    @GetMapping("/api/v1/users/inactives/admin")
    ResponseEntity<List<Object>> findInactiveUsers();

    @GetMapping("/api/v1/users/inactives")
    ResponseEntity<List<Object>> findInactiveUsersDto();

    @DeleteMapping("/api/v1/users/inactives/delete")
    ResponseEntity<?> deleteAllInactiveUsers();

    @PostMapping("/api/v1/users/login")
    ResponseEntity<String> loginUser(@RequestBody Object user);

    // Role endpoints
    @PostMapping("/api/v1/roles/create")
    ResponseEntity<Object> createRole(@RequestBody Object role);

    @GetMapping("/api/v1/roles/list")
    ResponseEntity<List<Object>> listRoles();

    @GetMapping("/api/v1/roles/{id}/details")
    ResponseEntity<Object> findRoleById(@PathVariable Integer id);

    @DeleteMapping("/api/v1/roles/{id}/delete")
    ResponseEntity<?> deleteRole(@PathVariable Integer id);
}