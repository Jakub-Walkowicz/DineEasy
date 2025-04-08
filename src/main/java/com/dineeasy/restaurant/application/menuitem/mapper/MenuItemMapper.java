package com.dineeasy.restaurant.application.menuitem.mapper;

import com.dineeasy.restaurant.application.menuitem.dto.MenuItemDTO;
import com.dineeasy.restaurant.domain.menuitem.entity.MenuItem;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MenuItemMapper {
    MenuItem toEntity(MenuItemDTO menuItemDTO);
    MenuItemDTO toDto(MenuItem menuItem);
}
