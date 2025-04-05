package com.dineeasy.restaurant.domain.address.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {
    @Size(min = 2, max = 50, message = "Country name must be between 2 and 50 characters")
    @Column(length = 50)
    private String country;

    @Pattern(regexp = "\\d{5}", message = "Postal code must be in the format XXXXX")
    @Column(length = 5)
    private String postalCode;

    @Column(length = 100)
    @Size(min = 2, max = 100, message = "City name must be between 2 and 100 characters")
    private String city;

    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Street name must be between 2 and 100 characters")
    private String streetName;

    @Column(length = 25)
    @Size(min = 2, max = 25, message = "Building number must be between 2 and 25 characters")
    private String buildingNumber;

    @Builder
    public Address(String country, String postalCode, String city, String streetName, String buildingNumber) {
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
    }
}
