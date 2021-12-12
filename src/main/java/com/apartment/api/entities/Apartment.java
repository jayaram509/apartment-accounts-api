package com.apartment.api.entities;

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
@Table(name = "apt_aprartment")
@Data
@NoArgsConstructor
public class Apartment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apartment_id")
	private Long apartmentId;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "apartment_uuid")
	private String apartmentUUID;

	@Column(name = "image_url")
	private String imageURL;

	@Column(name = "address_id")
	private String addreddId;


}
