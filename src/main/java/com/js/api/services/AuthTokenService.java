package com.js.api.services;

import com.js.api.dto.request.TokenRequest;
import com.js.api.entities.AuthToken;

public interface AuthTokenService {

	public AuthToken saveToken(TokenRequest request);
}
