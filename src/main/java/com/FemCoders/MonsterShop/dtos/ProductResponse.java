package com.FemCoders.MonsterShop.dtos;

public record ProductResponse(
        Long id,
        String name,
        Double price,
        String imageUrl,
        Double rating,
        int reviewCount,
        Boolean featured
) {
}




