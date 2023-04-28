package ru.vsu.cs.kapuchinka.webtech3.services;

import org.springframework.stereotype.Service;
import ru.vsu.cs.kapuchinka.webtech3.dto.GeoDto;
import ru.vsu.cs.kapuchinka.webtech3.dto.OrderDto;
import ru.vsu.cs.kapuchinka.webtech3.dto.PlaceDto;
import ru.vsu.cs.kapuchinka.webtech3.dto.ProductDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Place;
import ru.vsu.cs.kapuchinka.webtech3.entity.Product;

@Service
public class GeoService {
    private final OrderService orderService;
    private final PlaceService placeService;
    private final ProductService productService;

    public GeoService(OrderService orderService, PlaceService placeService, ProductService productService) {
        this.orderService = orderService;
        this.placeService = placeService;
        this.productService = productService;
    }

    public void addGeo(GeoDto geoDto) {
        OrderDto orderDto = new OrderDto();
        PlaceDto placeDto = new PlaceDto();
        ProductDto productDto = new ProductDto();

        placeDto.setNamePlace(geoDto.getNamePlace());
        placeDto.setPolygon(geoDto.getPolygon());

        productDto.setNameProduct(geoDto.getNameProduct());
        productDto.setTypeProduct(geoDto.getTypeProduct());

        Place place = placeService.saveNew(placeDto);
        Product product = productService.saveNew(productDto);

        orderDto.setPlaceId(place.getId());
        orderDto.setProductId(product.getId());

        orderService.saveNew(orderDto);
    }
}
