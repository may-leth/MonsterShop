package com.FemCoders.MonsterShop.dtos.Review;

public record ReviewResponse (
        String username,
        Double rating,
        String body
) {}
