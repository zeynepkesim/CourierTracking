package com.migros.couriertracking.dao;

import com.migros.couriertracking.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourierDao extends JpaRepository<Courier, Integer> {

}