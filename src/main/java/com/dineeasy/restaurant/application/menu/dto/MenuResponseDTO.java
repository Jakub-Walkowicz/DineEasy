package com.dineeasy.restaurant.application.menu.dto;

import com.dineeasy.restaurant.application.menuitem.dto.MenuItemDTO;
import com.dineeasy.restaurant.domain.menu.constant.MenuLanguage;
import com.dineeasy.restaurant.domain.menu.constant.MenuType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class MenuResponseDTO {
    private Long id;
    private String name;
    private Set<MenuItemDTO> items;
    private MenuType menuType;
    private MenuLanguage menuLanguage;
}
