package com.apartment.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String role;
	private String password;
	private String deviceUUID;
	private String deviceName;
	private String deviceDetails;
	private String vehicleNumber;
	
	
}
