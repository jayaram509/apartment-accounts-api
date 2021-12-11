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
@Table(name = "mek_bike_vendor")
@Data
@NoArgsConstructor
public class BikeVendor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bike_vendor_id")
	private Long bikeVendorId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name="image_url")
	private String imageURL;

}
