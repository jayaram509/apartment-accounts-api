package com.js.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js.api.dto.request.OTPRequest;

@RestController
@RequestMapping("/mobile/api/otp/v1")
public class OTPController {

	@PostMapping("/send")
	public ResponseEntity<?> sendOtp(OTPRequest request){
		return ResponseEntity.ok("234455");
	}
	@PostMapping("/verify")
	public ResponseEntity<?> verifyOTP(){
		return ResponseEntity.ok("234455");
	}
}
