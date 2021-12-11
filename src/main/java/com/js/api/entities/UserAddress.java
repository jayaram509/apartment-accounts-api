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
@Table(name = "mek_user_address")
@Data
@NoArgsConstructor
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_address_id")
	private Long userAddressId;

	@Column(name = "address_id")
	private Long addressId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "address_type")
	private String addressType;
}
