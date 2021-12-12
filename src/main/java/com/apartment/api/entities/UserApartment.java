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
@Table(name = "apt_user_aprartment")
@Data
@NoArgsConstructor
public class UserApartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_aprartment_id")
	private Long userAddressId;

	@Column(name = "aprartment_id")
	private Long apartmentId;
	
	@Column(name = "user_id")
	private Long userId;
	
	
}
