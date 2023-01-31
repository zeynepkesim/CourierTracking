package com.migros.couriertracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanceDto implements Serializable {

    private String storeName;
    private Double distanceInMeters;  //distance between courier and store in meters
    private Double distanceInMinutes; //distance between courier and store in minutes

}