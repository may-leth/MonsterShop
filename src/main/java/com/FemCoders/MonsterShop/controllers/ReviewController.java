package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.dtos.Review.ReviewRequest;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable long id){
        try{
            ReviewResponse response = reviewService.getReview(id);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ReviewResponse> addReview(@RequestBody @Valid ReviewRequest reviewRequest){
        ReviewResponse createdReview = reviewService.addReview(reviewRequest);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
