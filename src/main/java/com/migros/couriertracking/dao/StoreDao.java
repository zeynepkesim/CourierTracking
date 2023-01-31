package com.migros.couriertracking.dao;

import com.migros.couriertracking.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDao extends JpaRepository<Store, Integer> {

}