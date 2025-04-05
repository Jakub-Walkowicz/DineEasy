package com.dineeasy.restaurant.application.address.mapper;

import com.dineeasy.restaurant.application.address.dto.AddressDTO;
import com.dineeasy.restaurant.domain.address.valueobject.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity (AddressDTO addressDTO);
    AddressDTO toDto (Address address);
}
