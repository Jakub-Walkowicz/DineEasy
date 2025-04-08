package com.dineeasy.restaurant.application.diningtable.mapper;

import com.dineeasy.restaurant.application.diningtable.dto.DiningTableDTO;
import com.dineeasy.restaurant.domain.diningtable.entity.DiningTable;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface DiningTableMapper {
    DiningTable toEntity(DiningTableDTO diningTableDTO);
    DiningTableDTO toDto(DiningTable diningTable);
}
