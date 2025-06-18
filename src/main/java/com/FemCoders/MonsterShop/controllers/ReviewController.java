package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.dtos.Review.ReviewMapper;
import com.FemCoders.MonsterShop.dtos.Review.ReviewRequest;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable long id){
        return reviewService.getReview(id)
                .map(review -> ResponseEntity.ok(ReviewMapper.entityToDto(review)))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest);
        Review savedReview = reviewService.addReview(newReview);
        return new ResponseEntity<>(ReviewMapper.entityToDto(savedReview), HttpStatus.CREATED);
    }
}
