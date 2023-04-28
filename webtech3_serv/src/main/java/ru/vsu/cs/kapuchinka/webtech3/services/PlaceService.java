package ru.vsu.cs.kapuchinka.webtech3.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vsu.cs.kapuchinka.webtech3.dto.PlaceDto;
import ru.vsu.cs.kapuchinka.webtech3.entity.Place;
import ru.vsu.cs.kapuchinka.webtech3.mappers.PlaceMapper;
import ru.vsu.cs.kapuchinka.webtech3.repositories.PlaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    private final PlaceRepository repository;
    private final PlaceMapper mapper;

    public PlaceService(PlaceRepository repository, PlaceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PlaceDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public Place saveNew(PlaceDto placeDto) {
        return repository.save(mapper.toEntity(placeDto));
    }

    public void update(Integer id, PlaceDto placeDto) {
        Place oldPlace = repository.findById(id).get();
        Place newPlace = mapper.toEntity(placeDto);
        newPlace.setId(oldPlace.getId());
        repository.save(newPlace);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
