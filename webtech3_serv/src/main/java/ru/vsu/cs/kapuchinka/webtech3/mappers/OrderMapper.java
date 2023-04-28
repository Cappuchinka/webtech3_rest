package ru.vsu.cs.kapuchinka.webtech3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.kapuchinka.webtech3.dto.OrderDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Order;

@Mapper(componentModel = "Spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto toDto(Order order);
    Order toEntity(OrderDto dto);
}
