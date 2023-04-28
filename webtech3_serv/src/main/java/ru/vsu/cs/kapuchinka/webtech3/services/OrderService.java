package ru.vsu.cs.kapuchinka.webtech3.services;

import org.springframework.stereotype.Service;
import ru.vsu.cs.kapuchinka.webtech3.dto.OrderDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Order;
import ru.vsu.cs.kapuchinka.webtech3.mappers.OrderMapper;
import ru.vsu.cs.kapuchinka.webtech3.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository repository;
    private final OrderMapper mapper;

    public OrderService(OrderRepository repository, OrderMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<OrderDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Order saveNew(OrderDto orderDto) {
        return repository.save(mapper.toEntity(orderDto));
    }

    public void update(Integer id, OrderDto orderDto) {
        Order oldOrder = repository.findById(id).get();
        Order newOrder = mapper.toEntity(orderDto);
        newOrder.setId(oldOrder.getId());
        repository.save(newOrder);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
