package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.CourseServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gateway/courses")
public class CourseGatewayController {
    
    @Autowired
    private CourseServiceClient courseServiceClient;
    
    @GetMapping("/list")
    public ResponseEntity<List<Object>> getAllCourses() {
        return courseServiceClient.getAllCourses();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
        return courseServiceClient.getCourseById(id);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Object> createCourse(@RequestBody Object course) {
        return courseServiceClient.createCourse(course);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody Object course) {
        return courseServiceClient.updateCourse(id, course);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        return courseServiceClient.deleteCourse(id);
    }
}