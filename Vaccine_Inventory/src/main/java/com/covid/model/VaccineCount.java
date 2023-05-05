package com.covid.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
@Getter
@Setter
@Entity
public class VaccineCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vaccineCountId;
	
	
	@NotNull
	@NotEmpty
	private Integer quantity;
	
	@NotNull
	@NotEmpty
	private Double price;
	
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Vaccine vaccine;
	
	
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	private VaccineInventory vaccineInventory;

	
}
