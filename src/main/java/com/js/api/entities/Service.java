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
@Table(name="mek_service")
@Data
@NoArgsConstructor
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="service_id")
	private Long serviceId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="details")
	private String details;
	
	@Column(name="image_url")
	private String imageURL;
	
	// Genereal service
	//Oil Change
	//Electrical Issues
	// Clutch
	// Break
	// Engine
	// Noise issue
	//Silencer issues
	// Chain and Sprocket issues
	//Filter Change
	// Repaining
	//Scratch Removal
	// Tyre Puncure
	// Tyre Replacement
}
