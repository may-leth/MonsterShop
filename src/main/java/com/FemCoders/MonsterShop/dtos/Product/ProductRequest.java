package com.FemCoders.MonsterShop.dtos.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record ProductRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @Positive(message = "El precio debe ser mayor a 0")
        double price,

        @NotBlank(message = "La URL es obligatoria")
        String imageUrl,

        @Positive(message = "La calificación debe ser positiva")
        double rating,

        @PositiveOrZero(message = "El número de reseñas debe ser positivo")
        int reviewCount,

        @NotNull(message = "El campo featured es obligatorio")
        Boolean featured
) {
}
