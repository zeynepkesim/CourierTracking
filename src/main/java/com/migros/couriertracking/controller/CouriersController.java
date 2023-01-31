package com.migros.couriertracking.controller;

import com.migros.couriertracking.dto.CourierDto;
import com.migros.couriertracking.dto.DistanceDto;
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
import java.util.List;

@RestController
@RequestMapping("/api/couriers")
@CrossOrigin
public class CouriersController {

    private static final Logger logger = LoggerFactory.getLogger(CouriersController.class);

    private CourierService courierService;

    @Autowired
    public CouriersController(CourierService courierService) {
        this.courierService = courierService;
    }

    @PostMapping("/addcourier")
    public ResponseEntity<URI> addCourier(@RequestBody CourierDto courierDto) {
        try {
            courierService.addCourier(courierDto);
            int id = courierDto.getCourierId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/getdistancebetweencourierandstorelist")
    public List<DistanceDto> getDistanceBetweenCourierAndStoreList(@RequestBody GeolocationDto geolocationDto, @RequestParam(value = "speed") Double speed) {
        return courierService.getDistanceBetweenCourierAndStoreList(geolocationDto, speed);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    Double getTotalTravelDistance(@PathVariable("id") int courierId) {
        return courierService.getTotalTravelDistance(courierId);
    }

}