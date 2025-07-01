package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "${microservices.user-service.url}")
public interface UserServiceClient {

    @PostMapping("/api/v2/users/create")
    ResponseEntity<Object> createUser(@RequestBody Object user);

    @GetMapping("/api/v2/users/list")
    ResponseEntity<Object> listUsersAsDto();

    @GetMapping("/api/v2/users/list/admin")
    ResponseEntity<Object> listUsers();

    @GetMapping("/api/v2/users/{id}/details")
    ResponseEntity<Object> findUserByDTO(@PathVariable Integer id);

    @GetMapping("/api/v2/users/{id}/details/admin")
    ResponseEntity<Object> findUserById(@PathVariable Integer id);

    @PutMapping("/api/v2/users/{id}/full-update")
    ResponseEntity<Object> fullUpdateUser(@PathVariable Integer id, @RequestBody Object user);

    @PutMapping("/api/v2/users/{id}/update")
    ResponseEntity<Object> updateUser(@PathVariable Integer id, @RequestBody Object editDTO);

    @PutMapping("/api/v2/users/{id}/deactivate")
    ResponseEntity<Object> deactivateUser(@PathVariable Integer id, @RequestBody Object statusDTO);

    @PutMapping("/api/v2/users/{id}/role/edit")
    ResponseEntity<Object> updateUserRole(@PathVariable Integer id, @RequestBody Object roleDTO);

    @DeleteMapping("/api/v2/users/{id}/delete")
    ResponseEntity<?> deleteUser(@PathVariable Integer id);

    @GetMapping("/api/v2/users/inactives/admin")
    ResponseEntity<Object> findInactiveUsers();

    @GetMapping("/api/v2/users/inactives")
    ResponseEntity<Object> findInactiveUsersDto();

    @DeleteMapping("/api/v2/users/inactives/delete")
    ResponseEntity<?> deleteAllInactiveUsers();

    @PostMapping("/api/v2/users/login")
    ResponseEntity<String> loginUser(@RequestBody Object user);

    @PostMapping("/api/v2/roles/create")
    ResponseEntity<Object> createRole(@RequestBody Object role);

    @GetMapping("/api/v2/roles/list")
    ResponseEntity<Object> listRoles();

    @GetMapping("/api/v2/roles/{id}/details")
    ResponseEntity<Object> findRoleById(@PathVariable Integer id);

    @DeleteMapping("/api/v2/roles/{id}/delete")
    ResponseEntity<?> deleteRole(@PathVariable Integer id);
}