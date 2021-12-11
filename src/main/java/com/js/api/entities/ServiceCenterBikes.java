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
@Table(name="mek_service_center_bikes")
@Data
@NoArgsConstructor
public class ServiceCenterBikes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "service_center_bike_id")
	private Long serviceCenterBikeId;
	
	@Column(name="bike_id")
	private Long bikeId;
	
}
