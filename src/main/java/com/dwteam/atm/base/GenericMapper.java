package com.dwteam.atm.base;

import org.mapstruct.Mapper;

import java.util.List;


public interface GenericMapper<Entity,DTO> {
    Entity toEntity(DTO dto);
    DTO toDTO(Entity entity);
    List<Entity> toListEntity(List<DTO> dtoList);
    List<DTO> toListDTO(List<Entity> entityList);
}
