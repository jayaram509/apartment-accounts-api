package com.apartment.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apt_address")
@Data
@NoArgsConstructor
public class Address  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long addressId;
	
	@Column(name="house_number")
	private String houseNumber;
	
	@Column(name="address_line1")
	private String addressLine;
	
	@Column(name="address_line2")
	private String street;
	
	@Column(name="landmark")
	private String landmark;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pincode")
	private String pincode;
	
	@Column(name="location")
	private String location;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;
}
