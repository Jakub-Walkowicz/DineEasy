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
public class RestaurantDTO {
    @NotBlank(message = "Restaurant name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    private String name;

    @Valid
    @NotNull(message = "Address is required")
    private AddressDTO address;

    @Pattern(regexp = "^\\d{9,11}$", message = "Phone number must be between 9 and 11 digits")
    private String phoneNumber;

    @NotNull(message = "Opening time is required")
    private LocalTime openTime;

    @NotNull(message = "Closing time is required")
    private LocalTime closeTime;

    @Email(message = "Email must be a valid email address")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    @URL(message = "Website must be a valid URL")
    @Size(max = 255, message = "Website URL must not exceed 255 characters")
    private String website;
}
