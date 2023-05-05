package com.covid.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long centreId;
    private String state;
    private String city;
    private String pincode;
    private String locality;
    
//    @OneToOne(cascade = CascadeType.ALL)
//    private Appointment appointment;
    
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private VaccineInventory vaccineInventory;
    
}