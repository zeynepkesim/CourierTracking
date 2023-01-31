package com.migros.couriertracking.service;

import com.migros.couriertracking.Calculator;
import com.migros.couriertracking.dao.CourierDao;
import com.migros.couriertracking.dao.GeolocationDao;
import com.migros.couriertracking.dto.CourierDto;
import com.migros.couriertracking.dto.DistanceDto;
import com.migros.couriertracking.dto.GeolocationDto;
import com.migros.couriertracking.model.Courier;
import com.migros.couriertracking.model.Geolocation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {

    private static final Logger logger = LoggerFactory.getLogger(CourierServiceImpl.class);

    private static final int CONSTANT_RADIUS = 100;
    private static final int CONSTANT_TIME = 1;

    private CourierDao courierDao;

    private GeolocationDao geolocationDao;

    private ModelMapper modelMapper;

    @Autowired
    public CourierServiceImpl(CourierDao courierDao, GeolocationDao geolocationDao, ModelMapper modelMapper) {
        this.courierDao = courierDao;
        this.geolocationDao = geolocationDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCourier(CourierDto courierDto) {
        Courier courier = modelMapper.map(courierDto, Courier.class);
        courierDao.save(courier);
    }

    @Override
    public void addGeolocation(GeolocationDto geolocationDto) {
        Geolocation geolocation = modelMapper.map(geolocationDto, Geolocation.class);
        geolocationDao.save(geolocation);
    }

    @Override
    public List<DistanceDto> getDistanceBetweenCourierAndStoreList(GeolocationDto geolocationDto, Double speed) {
        List<DistanceDto> distanceBetweenCourierAndStoreList = new ArrayList<>();
        try {
            List<Geolocation> storeGeolocationList = geolocationDao.findAllBy();
            DistanceDto distanceDto = new DistanceDto();
            storeGeolocationList.forEach(store -> {
                double distanceInMeters = Calculator.calculateDistance(geolocationDto.getLatitude(), geolocationDto.getLongitude(),
                        store.getLatitude(), store.getLongitude());
                double distanceInMinutes = Calculator.calculateTime(distanceInMeters, speed);
                if (distanceInMeters < CONSTANT_RADIUS && distanceInMinutes > CONSTANT_TIME) {
                    distanceDto.setStoreName(store.getStore().getStoreName());
                    distanceDto.setDistanceInMeters(distanceInMeters);
                    distanceDto.setDistanceInMinutes(distanceInMinutes);
                    distanceBetweenCourierAndStoreList.add(distanceDto);
                }
            });
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return distanceBetweenCourierAndStoreList;
    }

    //Calculates the total distance, over which any courier travels (by courierId).
    @Override
    public Double getTotalTravelDistance(int courierId) {
        double totalDistance = 0.0;
        try {
            List<Geolocation> list = geolocationDao.getByCourier_CourierId(courierId);
            for (int i = 0; i < list.size() - 1; i++) {
                totalDistance += Calculator.calculateDistance(list.get(i).getLatitude(), list.get(i).getLongitude(), list.get(i + 1).getLongitude(),
                        list.get(i + 1).getLongitude());
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return totalDistance;
    }

}