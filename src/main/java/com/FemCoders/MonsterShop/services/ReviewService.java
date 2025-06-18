package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.dtos.Review.ReviewMapper;
import com.FemCoders.MonsterShop.dtos.Review.ReviewRequest;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public ReviewResponse getReview(Long id){
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Reseña con ID " + id + " No encontrada"));
        return ReviewMapper.entityToDto(review);
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest){
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest);
        Review saved = reviewRepository.save(newReview);
        return  ReviewMapper.entityToDto(saved);
    }
}
