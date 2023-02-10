package com.java.aadityadesigners.common.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityConverter {

    private final ModelMapper modelMapper= new ModelMapper();

    public <D, T> D convertToDto(T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }
    public <D, T> T convertToEntity(D dto, Class<T> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <D, T> List<D> convertToDtoList(List<T> entityList, Class<D> dtoClass) {
        return entityList.stream()
            .map(entity -> convertToDto(entity, dtoClass))
            .collect(Collectors.toList());
    }
    public <D, T> List<T> convertToEntityList(List<D> dtoList, Class<T> entityClass) {
        return dtoList.stream()
            .map(dto -> convertToEntity(dto, entityClass))
            .collect(Collectors.toList());
    }
}