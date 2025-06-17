package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Optional<Review> getReview(Long id){
        return reviewRepository.findById(id);
    }

    public Review addReview(Review newReview){
        return reviewRepository.save(newReview);
    }
}
