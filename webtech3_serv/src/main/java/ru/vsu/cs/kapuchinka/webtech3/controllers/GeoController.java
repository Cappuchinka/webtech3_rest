package ru.vsu.cs.kapuchinka.webtech3.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.kapuchinka.webtech3.dto.GeoDto;
import ru.vsu.cs.kapuchinka.webtech3.services.GeoService;

@RestController
public class GeoController {
    private final GeoService service;

    public GeoController(GeoService service) {
        this.service = service;
    }

    @PostMapping("/geo/add")
    public void addGeo(@RequestBody GeoDto geoDto) {
        service.addGeo(geoDto);
    }
}
