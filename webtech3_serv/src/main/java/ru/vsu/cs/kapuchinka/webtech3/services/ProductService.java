package ru.vsu.cs.kapuchinka.webtech3.services;

import org.springframework.stereotype.Service;
import ru.vsu.cs.kapuchinka.webtech3.dto.ProductDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Product;
import ru.vsu.cs.kapuchinka.webtech3.mappers.ProductMapper;
import ru.vsu.cs.kapuchinka.webtech3.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ProductDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Product saveNew(ProductDto productDto) {
        return repository.save(mapper.toEntity(productDto));
    }

    public void update(Integer id, ProductDto productDto) {
        Product oldProduct = repository.findById(id).get();
        Product newProduct = mapper.toEntity(productDto);
        newProduct.setId(oldProduct.getId());
        repository.save(newProduct);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
