package com.dineeasy.restaurant.application.menuitem.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MenuItemDTO {
    private String name;
    private Double price;
}
