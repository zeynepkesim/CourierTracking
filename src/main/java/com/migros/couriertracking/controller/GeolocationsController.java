package com.migros.couriertracking.controller;

import com.migros.couriertracking.dto.GeolocationDto;
import com.migros.couriertracking.service.CourierService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/geolocations")
@CrossOrigin
public class GeolocationsController {

    private static final Logger logger = LoggerFactory.getLogger(GeolocationsController.class);

    private CourierService courierService;

    @Autowired
    public GeolocationsController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/addgeolocation")
    public ResponseEntity<URI> addGeolocation(@RequestBody GeolocationDto geolocationDto) {
        try {
            courierService.addGeolocation(geolocationDto);
            int id = geolocationDto.getGeolocationId();
            URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(url).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}