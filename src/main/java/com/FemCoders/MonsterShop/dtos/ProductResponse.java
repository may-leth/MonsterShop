package com.FemCoders.MonsterShop.dtos;

public record ProductResponse(
        Long id,
        String name,
        double price,
        String imageUrl,
        double rating,
        double productRating,
        int reviewCount,
        boolean featured
) {
}

