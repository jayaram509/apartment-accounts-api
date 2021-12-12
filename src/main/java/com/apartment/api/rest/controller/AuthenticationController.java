package com.apartment.api.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apartment.api.dto.request.LoginRequest;
import com.apartment.api.dto.request.UserRegisterRequest;
import com.apartment.api.dto.request.UserUpdateRequet;
import com.apartment.api.dto.response.AuthenticationResponse;
import com.apartment.api.dto.response.UserResponse;
import com.apartment.api.entities.User;
import com.apartment.api.exception.ApplicationException;
import com.apartment.api.sercurity.JWTTokenUtil;
import com.apartment.api.sercurity.MekUserDetails;
import com.apartment.api.services.UserService;

@RestController
@RequestMapping("/user/v1")
public class AuthenticationController  {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private JWTTokenUtil jwtTokenUtils;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUserAccount(@RequestBody UserRegisterRequest requset) throws ApplicationException{
		UserResponse response = new UserResponse();
		User user = userService.createUser(requset);
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/refreshToken")
	public ResponseEntity<?> refreshToken(@RequestBody UserRegisterRequest requset) throws ApplicationException{
		UserResponse response = new UserResponse();
		User user = userService.createUser(requset);
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/update-user-info")
	public ResponseEntity<?> updateUserDetails(@RequestBody UserUpdateRequet requset) throws ApplicationException{
		UserResponse response = new UserResponse();
		User user = userService.updateUser(requset);
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/do-auth")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtils.generateToken(authentication);
		MekUserDetails userDetails = (MekUserDetails) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		AuthenticationResponse res = AuthenticationResponse.builder().email(userDetails.getUsername()).token(jwt).roles(roles).build();
		return ResponseEntity.ok(res);
	}
	
	
	@GetMapping("/token")
	public ResponseEntity<?> getToken(){
		return ResponseEntity.ok("234455");
	}
	@PostMapping("/forgot-password")
	public ResponseEntity<?> forgotPassword(@RequestBody LoginRequest request){
		UserResponse response = new UserResponse();
		User user = userService.authenticateUser(request.getUserName(),request.getPassword());
		return  ResponseEntity.ok(user);
	}
	
	@PostMapping("/verify-email")
	public ResponseEntity<?> verifyEmail(@RequestBody LoginRequest request){
		UserResponse response = new UserResponse();
		User user = userService.authenticateUser(request.getUserName(),request.getPassword());
		return  ResponseEntity.ok(user);
	}
	@PostMapping("/verify-phone")
	public ResponseEntity<?> verifyPhone(@RequestBody LoginRequest request){
		UserResponse response = new UserResponse();
		User user = userService.authenticateUser(request.getUserName(),request.getPassword());
		return  ResponseEntity.ok(user);
	}
	
	
}
