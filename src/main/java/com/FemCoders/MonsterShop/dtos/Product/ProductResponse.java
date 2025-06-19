package com.FemCoders.MonsterShop.dtos.Product;

import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        Double price,
        String imageUrl,
        Double rating,
        Integer reviewCount,
        Boolean featured,
        List<ReviewResponse> reviews
) {
}