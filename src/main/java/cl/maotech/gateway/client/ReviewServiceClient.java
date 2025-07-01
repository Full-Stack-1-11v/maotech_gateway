package cl.maotech.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.maotech.gateway.dto.ReviewDTO;

import java.util.List;

@FeignClient(name = "review-service", url = "${microservices.review-service.url}")
public interface ReviewServiceClient {

    @PostMapping("/api/v1/reviews")
    ResponseEntity<EntityModel<ReviewDTO>> createReview(@RequestBody ReviewDTO review);

    @GetMapping("/api/v1/reviews")
    ResponseEntity<List<EntityModel<ReviewDTO>>> getReviews();

    @GetMapping("/api/v1/reviews/{id}")
    ResponseEntity<EntityModel<ReviewDTO>> getReviewById(@PathVariable Integer id);

    @PutMapping("/api/v1/reviews/{id}")
    ResponseEntity<ReviewDTO> updateReview(@PathVariable Integer id, @RequestBody ReviewDTO review);
}