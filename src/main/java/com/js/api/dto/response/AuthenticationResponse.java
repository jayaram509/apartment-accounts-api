package com.js.api.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
}
