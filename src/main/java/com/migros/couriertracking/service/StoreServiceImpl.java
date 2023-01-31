package com.migros.couriertracking.service;

import com.migros.couriertracking.dao.StoreDao;
import com.migros.couriertracking.dto.StoreDto;
import com.migros.couriertracking.model.Store;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {

    private StoreDao storeDao;

    private ModelMapper modelMapper;

    @Autowired
    public StoreServiceImpl(StoreDao storeDao, ModelMapper modelMapper) {
        this.storeDao = storeDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addStore(StoreDto storeDto) {
        Store store = modelMapper.map(storeDto, Store.class);
        storeDao.save(store);
    }

}