package com.migros.couriertracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {

    private int courierId;
    private String courierName;
    private String courierSurname;

}