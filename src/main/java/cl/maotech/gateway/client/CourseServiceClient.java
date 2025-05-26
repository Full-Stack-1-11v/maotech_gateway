package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "course-service", url = "${microservices.course-service.url}")
public interface CourseServiceClient {

    @GetMapping("/cursos")
    ResponseEntity<List<Object>> getAllCourses();

    @GetMapping("/cursos/{id}")
    ResponseEntity<Object> getCourseById(@PathVariable Long id);

    @PostMapping("/cursos")
    ResponseEntity<Object> createCourse(@RequestBody Object course);

    @PutMapping("/cursos/{id}")
    ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody Object course);

    @DeleteMapping("/cursos/{id}")
    ResponseEntity<Void> deleteCourse(@PathVariable Long id);
}