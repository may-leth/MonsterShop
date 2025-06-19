package com.FemCoders.MonsterShop.dtos.Review;

import jakarta.validation.constraints.*;

public record ReviewRequest(
        @NotBlank(message = "El nombre de usuario es obligatorio")
        String username,

        @NotNull(message = "La calificación es obligatoria")
        @Min(value = 1, message = "La calificación mínima es 1")
        @Max(value = 5, message = "La calificación máxima es 5")
        Double rating,


        String body,

        @NotNull(message = "El ID del producto es obligatorio")
        Long productId
) {
}
