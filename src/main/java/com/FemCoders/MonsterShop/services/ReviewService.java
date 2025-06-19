package com.FemCoders.MonsterShop.services;

import com.FemCoders.MonsterShop.dtos.Review.ReviewMapper;
import com.FemCoders.MonsterShop.dtos.Review.ReviewRequest;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.models.Review;
import com.FemCoders.MonsterShop.repositories.ProductRepository;
import com.FemCoders.MonsterShop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    public List<ReviewResponse> getReviewByProduct(Long productId){
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).collect(Collectors.toList());
    }

    public ReviewResponse addReview(ReviewRequest reviewRequest){
        Product product = productRepository.findById(reviewRequest.productId())
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el producto"));
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest, product);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);
    }
}
