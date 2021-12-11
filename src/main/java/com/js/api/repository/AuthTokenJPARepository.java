package com.js.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.js.api.entities.AuthToken;
import com.js.api.entities.User;

public interface AuthTokenJPARepository extends JpaRepository<AuthToken, Long> {

	Optional<AuthToken> findByToken(String token);
}
