package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "content-service", url = "${microservices.content-service.url}")
public interface ContentServiceClient {

    @PostMapping("/content")
    Object createContent(@RequestBody Object content);

    @GetMapping("/content")
    List<Object> getAllContents();

    @GetMapping("/content/search")
    List<Object> getContentByTypeAndStatus(@RequestParam String type, @RequestParam String status);

    @GetMapping("/content/{id}")
    Object getContentById(@PathVariable Long id);

    @PutMapping("/content/{id}")
    Object updateContent(@PathVariable Long id, @RequestBody Object content);

    @DeleteMapping("/content/{id}")
    void deleteContent(@PathVariable Long id);
}