package com.apartment.api.dto.request;

import lombok.Data;

@Data
public class OTPRequest {

	private long countryCode;
	private Long phoneNumber;
	private Long otp;
	
}
