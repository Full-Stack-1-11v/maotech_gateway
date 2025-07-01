package cl.maotech.gateway.controller;

import cl.maotech.gateway.client.ReviewServiceClient;
import cl.maotech.gateway.dto.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewGatewayController {
    
    @Autowired
    private ReviewServiceClient reviewServiceClient;
    
    @PostMapping
    public ResponseEntity<EntityModel<ReviewDTO>> createReview(@RequestBody ReviewDTO review) {
        return reviewServiceClient.createReview(review);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<ReviewDTO>>> getReviews() {
        return reviewServiceClient.getReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ReviewDTO>> getReviewById(@PathVariable Integer id) {
        return reviewServiceClient.getReviewById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Integer id, @RequestBody ReviewDTO review) {
        return reviewServiceClient.updateReview(id, review);
    }
}