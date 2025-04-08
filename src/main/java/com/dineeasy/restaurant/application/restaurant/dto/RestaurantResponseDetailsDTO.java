package com.dineeasy.restaurant.application.restaurant.dto;

import com.dineeasy.restaurant.application.address.dto.AddressDTO;
import com.dineeasy.restaurant.application.diningtable.dto.DiningTableDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
public class RestaurantResponseDetailsDTO {
    private String name;
    private Set<MenuResponseDTO> menus;
    private Set<DiningTableDTO> diningTables;
    private AddressDTO address;
    private Integer ratingNumber;
    private Double averageRating;
    private String phoneNumber;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String email;
    private String website;
    private LocalDateTime modifyDateTime;
}
