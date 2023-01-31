package com.migros.couriertracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeolocationDto {

    private int geolocationId;
    private Double latitude;
    private Double longitude;
    private CourierDto courierDto;
    private StoreDto storeDto;

}