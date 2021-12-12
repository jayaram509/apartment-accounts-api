package com.apartment.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.api.dto.request.OTPRequest;

@RestController
@RequestMapping(path = "/payment/v1")
public class PaymentGatewayController {

	@PostMapping("/callback")
	public ResponseEntity<?> sendOtp(OTPRequest request){
		return ResponseEntity.ok("apartment success");
	}
	
	@GetMapping(value = "health")
	public ResponseEntity<?>  health() {
		return ResponseEntity.ok("apartment success");
	}
}
