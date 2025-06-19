package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.dtos.Review.ReviewRequest;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewResponse>> getReviewByProduct(@PathVariable long productId){
        List<ReviewResponse> reviews = reviewService.getReviewByProduct(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        ReviewResponse createdReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
