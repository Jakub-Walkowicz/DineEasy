package com.dineeasy.restaurant.application.menu.dto;

import com.dineeasy.restaurant.application.menuitem.dto.MenuItemDTO;
import com.dineeasy.restaurant.domain.menu.constant.MenuLanguage;
import com.dineeasy.restaurant.domain.menu.constant.MenuType;

import java.util.Set;

public class MenuUpdateDTO {
    private String name;
    private Set<MenuItemDTO> items;
    private MenuType menuType;
    private MenuLanguage menuLanguage;
}
