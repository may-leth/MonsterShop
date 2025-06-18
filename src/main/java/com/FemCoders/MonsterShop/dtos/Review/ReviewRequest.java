package com.FemCoders.MonsterShop.dtos.Review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ReviewRequest(
        @NotBlank(message = "El nombre de usuario es obligatorio")
        String username,

        @Positive(message = "La calificación no debe ser negativa")
        Double rating,

        @NotBlank(message = "El cuerpo de la reseña es obligatorio")
        String body
) {
}
