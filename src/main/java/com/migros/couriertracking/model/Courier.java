package com.migros.couriertracking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "couriers")
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courierId;

    @Column(name = "courier_name")
    private String courierName;

    @Column(name = "courier_surname")
    private String courierSurname;

}