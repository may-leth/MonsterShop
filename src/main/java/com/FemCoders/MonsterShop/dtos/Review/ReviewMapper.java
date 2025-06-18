package com.FemCoders.MonsterShop.dtos.Review;

import com.FemCoders.MonsterShop.models.Review;
import jdk.jfr.Category;

import java.util.List;

public class ReviewMapper {
    public static Review dtoToEntity(ReviewRequest dto){
        return new Review(
                dto.username(),
                dto.rating(),
                dto.body()
        );
    }

    public static ReviewResponse entityToDto (Review review){
        return new ReviewResponse(
                review.getUsername(),
                review.getRating(),
                review.getBody()
        );
    }
}
