package com.migros.couriertracking.controller;

import com.migros.couriertracking.dto.StoreDto;
import com.migros.couriertracking.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/stores")
@CrossOrigin
public class StoresController {

    private static final Logger logger = LoggerFactory.getLogger(StoresController.class);
    private StoreService storeService;

    @Autowired
    public StoresController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("/addstore")
    public ResponseEntity<URI> addStore(@RequestBody StoreDto storeDto) {
        try {
            storeService.addStore(storeDto);
            int id = storeDto.getStoreId();
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}