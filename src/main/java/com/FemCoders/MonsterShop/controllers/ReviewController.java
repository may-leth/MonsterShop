package com.FemCoders.MonsterShop.controllers;

import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getReviews(){
        List<Review> reviews = reviewService.getReviews();
        return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review newReview){
        Review createdReview = reviewService.addReview(newReview);
        return new ResponseEntity<Review>(createdReview, HttpStatus.CREATED);
    }
}
