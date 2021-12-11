package com.js.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="mek_car")
@Data
@NoArgsConstructor
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="car_id")
	private Long carId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="color")
	private String color;
	
	@Column(name="fuel_type")
	private String fuelType;
	
	@Column(name="max_power")
	private String maxPower;
	
	@Column(name="emission_type")
	private String emissionStandard;
}
