package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.ContentServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentGatewayController {
    
    @Autowired
    private ContentServiceClient contentServiceClient;
    
    @GetMapping("/list")
    public List<Object> getAllContents() {
        return contentServiceClient.getAllContents();
    }

    @GetMapping("/search")
    public List<Object> searchContent(@RequestParam String type, @RequestParam String status) {
        return contentServiceClient.getContentByTypeAndStatus(type, status);
    }
    
    @GetMapping("/{id}")
    public Object getContentById(@PathVariable Long id) {
        return contentServiceClient.getContentById(id);
    }
    
    @PostMapping("/create")
    public Object createContent(@RequestBody Object content) {
        return contentServiceClient.createContent(content);
    }
    
    @PutMapping("/{id}")
    public Object updateContent(@PathVariable Long id, @RequestBody Object content) {
        return contentServiceClient.updateContent(id, content);
    }
    
    @DeleteMapping("/{id}")
    public void deleteContent(@PathVariable Long id) {
        contentServiceClient.deleteContent(id);
    }
}