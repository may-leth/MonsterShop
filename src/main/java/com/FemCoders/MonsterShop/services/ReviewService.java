package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }

    public Review addReview(Review newReview){
        return reviewRepository.save(newReview);
    }
}
