package com.FemCoders.MonsterShop.dtos.Product;

import com.FemCoders.MonsterShop.dtos.Review.ReviewMapper;
import com.FemCoders.MonsterShop.dtos.Review.ReviewResponse;
import com.FemCoders.MonsterShop.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto){
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setImageUrl(dto.imageUrl());
        product.setRating(dto.rating() != null ? dto.rating() : 0);
        return product;
    }

    public static ProductResponse entityToDto(Product product){
        List<ReviewResponse> reviews = product.getReviews() != null
                ? product.getReviews().stream().map(ReviewMapper::entityToDto).collect(Collectors.toList())
                : List.of();
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getImageUrl(),
                product.getRating(),
                product.getReviewCount(),
                product.isFeatured(),
                reviews
        );
    }
}
