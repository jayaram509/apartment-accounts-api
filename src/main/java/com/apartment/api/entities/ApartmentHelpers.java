package com.apartment.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apt_apartment_helpers")
@Data
@NoArgsConstructor
public class ApartmentHelpers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "apartment_helper_id")
	private Long herlperId;

	@Column(name = "helper_name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;
	
	@Column(name = "rating")
	private Double rating;
	
	
}
