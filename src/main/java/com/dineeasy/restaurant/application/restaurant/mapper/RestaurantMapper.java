package com.dineeasy.restaurant.application.restaurant.mapper;

import com.dineeasy.restaurant.application.address.mapper.AddressMapper;
import com.dineeasy.restaurant.application.diningtable.mapper.DiningTableMapper;
import com.dineeasy.restaurant.application.menu.mapper.MenuMapper;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantCreateDTO;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantResponseDTO;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantResponseDetailsDTO;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantUpdateDTO;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {AddressMapper.class, MenuMapper.class, DiningTableMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RestaurantMapper {
    Restaurant toEntity (RestaurantCreateDTO restaurantCreateDTO);
    RestaurantResponseDTO toDto (Restaurant restaurant);
    void updateEntityFromDto(RestaurantUpdateDTO dto, @MappingTarget Restaurant entity);
    RestaurantResponseDetailsDTO toDetailsDto (Restaurant restaurant);
}