package ru.vsu.cs.kapuchinka.webtech3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.kapuchinka.webtech3.dto.PlaceDto;
import ru.vsu.cs.kapuchinka.webtech3.services.PlaceService;

import java.util.List;

@RestController
public class PlaceController {
    private final PlaceService service;

    public PlaceController(PlaceService service) {
        this.service = service;
    }

    @GetMapping("/places")
    public List<PlaceDto> getAllPlaces() {
        return service.getAll();
    }

    @PostMapping("/place/new")
    public void saveNewPlace(@RequestBody PlaceDto placeDto) {
        service.saveNew(placeDto);
    }

    @PutMapping("/place/update/{id}")
    public void updatePlace(@PathVariable Integer id, @RequestBody PlaceDto placeDto) {
        service.update(id, placeDto);
    }

    @DeleteMapping("/place/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
