package ru.vsu.cs.kapuchinka.webtech3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.kapuchinka.webtech3.dto.PlaceDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Place;

@Mapper(componentModel = "Spring")
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);
    PlaceDto toDto(Place place);
    Place toEntity(PlaceDto placeDto);
}
