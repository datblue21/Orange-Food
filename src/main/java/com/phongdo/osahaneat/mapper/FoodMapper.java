package com.phongdo.osahaneat.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.phongdo.osahaneat.domain.entity.Food;
import com.phongdo.osahaneat.dto.response.MenuDTO;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    Food toEntity(MenuDTO menuDTO);

    MenuDTO toDTO(Food food);

    List<MenuDTO> toDTOList(List<Food> foods);
}
