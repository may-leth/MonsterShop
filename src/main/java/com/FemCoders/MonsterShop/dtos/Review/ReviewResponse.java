package com.FemCoders.MonsterShop.dtos.Review;

public record ReviewResponse (
        Long id,
        String username,
        Double rating,
        String body,
        Long productId
) {}
