package ru.vsu.cs.kapuchinka.webtech3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.kapuchinka.webtech3.dto.ProductDto;
import ru.vsu.cs.kapuchinka.webtech3.services.ProductService;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    public List<ProductDto> getAllPlaces() {
        return service.getAll();
    }

    @PostMapping("/product/new")
    public void saveNewProduct(@RequestBody ProductDto productDto) {
        service.saveNew(productDto);
    }

    @PutMapping("/product/update/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        service.update(id, productDto);
    }

    @DeleteMapping("/product/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
