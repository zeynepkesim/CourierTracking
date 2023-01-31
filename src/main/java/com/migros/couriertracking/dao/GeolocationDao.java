package com.migros.couriertracking.dao;

import com.migros.couriertracking.model.Geolocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeolocationDao extends JpaRepository<Geolocation, Integer> {

    List<Geolocation> getByCourier_CourierId(int courierId);

    List<Geolocation> findAllBy();

}