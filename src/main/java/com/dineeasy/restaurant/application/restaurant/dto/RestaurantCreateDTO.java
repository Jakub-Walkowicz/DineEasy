package com.dineeasy.restaurant.application.restaurant.dto;

import com.dineeasy.restaurant.application.address.dto.AddressDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class RestaurantCreateDTO {
    private String name;
    private AddressDTO address;
    private String phoneNumber;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String email;
    private String website;
}
