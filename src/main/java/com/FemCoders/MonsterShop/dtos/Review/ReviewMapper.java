package com.FemCoders.MonsterShop.dtos.Review;

import com.FemCoders.MonsterShop.models.Product;
import com.FemCoders.MonsterShop.models.Review;

public class ReviewMapper {
    public static Review dtoToEntity(ReviewRequest dto, Product product){
        return new Review(
                null,
                dto.username(),
                dto.rating(),
                dto.body(),
                product
        );
    }

    public static ReviewResponse entityToDto (Review review){
        Long product = review.getProduct().getId();
        return new ReviewResponse(
                review.getId(),
                review.getUsername(),
                review.getRating(),
                review.getBody(),
                product
        );
    }
}
