package com.dineeasy.restaurant.application.restaurant.dto;

import com.dineeasy.restaurant.application.address.dto.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalTime;

@Getter
@Setter
public class UpdateRestaurantDTO {
    private Long id;

    @Size(max = 100, message = "Restaurant name must be less than 100 characters")
    private String name;

    @Valid
    private AddressDTO address;

    @Pattern(regexp = "^\\d{9,11}$", message = "Phone number must be between 9 and 11 digits")
    private String phoneNumber;

    private LocalTime openTime;
    private LocalTime closeTime;

    @Email(message = "Email must be valid")
    private String email;

    @URL(message = "Website URL must be valid")
    private String website;
}