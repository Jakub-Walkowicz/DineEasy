package com.dineeasy.restaurant.api.restaurant.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateRestaurantDTO {
    private String phoneNumber;
    private String name;
}