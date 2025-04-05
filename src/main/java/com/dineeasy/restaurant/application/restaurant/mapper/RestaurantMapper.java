package com.dineeasy.restaurant.application.restaurant.mapper;

import com.dineeasy.restaurant.application.address.mapper.AddressMapper;
import com.dineeasy.restaurant.application.restaurant.dto.RestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.ResponseRestaurantDTO;
import com.dineeasy.restaurant.application.restaurant.dto.UpdateRestaurantDTO;
import com.dineeasy.restaurant.domain.restaurant.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        uses = {AddressMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface RestaurantMapper {
    Restaurant toEntity (RestaurantDTO restaurantDTO);
    ResponseRestaurantDTO toDto (Restaurant restaurant);
    void updateEntityFromDto(UpdateRestaurantDTO dto, @MappingTarget Restaurant entity);
}