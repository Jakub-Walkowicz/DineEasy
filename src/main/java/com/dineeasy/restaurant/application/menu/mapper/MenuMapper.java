package com.dineeasy.restaurant.application.menu.mapper;

import com.dineeasy.restaurant.application.menu.dto.MenuCreateDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDTO;
import com.dineeasy.restaurant.application.menu.dto.MenuResponseDetailsDTO;
import com.dineeasy.restaurant.application.menuitem.mapper.MenuItemMapper;
import com.dineeasy.restaurant.domain.menu.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {MenuItemMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface MenuMapper {
    Menu toEntity(MenuCreateDTO menuCreateDTO);
    MenuResponseDTO toDto(Menu menu);
    MenuResponseDetailsDTO toDetailsDto(Menu menu);
}
