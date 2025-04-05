package com.dineeasy.restaurant.application.restaurant.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingDTO {
    @DecimalMin("1.0")
    @DecimalMax("5.0")
    private double rating;
}
