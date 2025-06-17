package com.FemCoders.MonsterShop.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductRequest(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        @NotBlank(message = "El precio es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        double price,

        @NotBlank(message = "La URL es obligatoria")
        String imageUrl,

        @Positive(message = "La calificación debe ser positiva")
        double rating,

        @Positive(message = "El número de reseñas debe ser positivo")
        int reviewCount,

        @NotNull(message = "El campo featured es obligatorio")
        Boolean featured
) {
}
