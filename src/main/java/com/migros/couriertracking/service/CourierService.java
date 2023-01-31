package com.migros.couriertracking.service;

import com.migros.couriertracking.dto.CourierDto;
import com.migros.couriertracking.dto.DistanceDto;
import com.migros.couriertracking.dto.GeolocationDto;

import java.util.List;

public interface CourierService {

    void addCourier(CourierDto courierDto);

    void addGeolocation(GeolocationDto geolocationDto);

    List<DistanceDto> getDistanceBetweenCourierAndStoreList(GeolocationDto geolocationDto, Double speed);

    Double getTotalTravelDistance(int courierId);

}