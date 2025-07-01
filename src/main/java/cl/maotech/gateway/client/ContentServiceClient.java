package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "content-service", url = "${microservices.content-service.url}")
public interface ContentServiceClient {

    @PostMapping("v2/content")
    Object createContent(@RequestBody Object content);

    @GetMapping("v2/content")
    List<Object> getAllContents();

    @GetMapping("v2/content/search")
    List<Object> getContentByTypeAndStatus(@RequestParam String type, @RequestParam String status);

    @GetMapping("v2/content/{id}")
    Object getContentById(@PathVariable Long id);

    @PutMapping("v2/content/{id}")
    Object updateContent(@PathVariable Long id, @RequestBody Object content);

    @DeleteMapping("v2/content/{id}")
    void deleteContent(@PathVariable Long id);
}