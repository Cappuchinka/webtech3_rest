package ru.vsu.cs.kapuchinka.webtech3.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.vsu.cs.kapuchinka.webtech3.dto.ProductDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Product;

@Mapper(componentModel = "Spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
