package com.dineeasy.restaurant.application.address.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private String country;
    private String postalCode;
    private String city;
    private String streetName;
    private String buildingNumber;
}
