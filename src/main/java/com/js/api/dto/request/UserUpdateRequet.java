package com.js.api.dto.request;

import java.util.List;

import lombok.Data;

@Data
public class UserUpdateRequet {

	private Long userId;
	private List<BikeDetails> bikes;
	private List<CarDetails> cars;
	private String phoneNumber;
	private String email;
	private String password;
}

@Data
class BikeDetails {
	
	private Long bikeId;
	private String bikeName;
	private String registeredNumber;
	
}
@Data
class CarDetails {
	
	private Long carId;
	private String carName;
	private String registeredNumber;
}