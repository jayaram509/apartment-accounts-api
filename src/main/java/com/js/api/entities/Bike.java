package com.js.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_bike")
@Data
@NoArgsConstructor
public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bike_id")
	private Long bikeId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "bike_vendor_id")
	private Long bikeVendorId;

	@Column(name = "vendor_name")
	private String vendorName;

	@Column(name = "color")
	private String color;

	@Column(name = "fuel_type")
	private String fuelType;

	@Column(name = "max_power")
	private String maxPower;

	@Column(name = "emission_type")
	private String emissionStandard;

}
