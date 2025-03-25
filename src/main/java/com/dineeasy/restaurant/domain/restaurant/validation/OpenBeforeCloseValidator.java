package com.dineeasy.restaurant.domain.restaurant.validation;

import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class OpenBeforeCloseValidator implements ConstraintValidator<OpenBeforeClose, Restaurant> {

    @Override
    public boolean isValid(Restaurant restaurant, ConstraintValidatorContext context) {
        return restaurant.getOpenTime().isBefore(restaurant.getCloseTime());
    }
}
