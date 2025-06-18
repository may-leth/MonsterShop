package com.FemCoders.MonsterShop.dtos.Review;

public record ReviewResponse (
        String username,
        double rating,
        String Body
) {}
