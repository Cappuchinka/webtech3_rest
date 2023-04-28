package ru.vsu.cs.kapuchinka.webtech3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.kapuchinka.webtech3.dto.OrderDto;
import ru.vsu.cs.kapuchinka.webtech3.services.OrderService;

import java.util.List;

@RestController
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/orders")
    public List<OrderDto> getAllOrders() {
        return service.getAll();
    }

    @PostMapping("/order/new")
    public void saveNewOrder(@RequestBody OrderDto orderDto) {
        service.saveNew(orderDto);
    }

    @PutMapping("/order/update/{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody OrderDto orderDto) {
        service.update(id, orderDto);
    }

    @DeleteMapping("/order/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
