package com.js.api.sercurity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JWTTokenUtil {

	@Value("${security.jwt.secrect}")
	private String jwtSecrectCode;

	@Value("${security.jwt.expiration.time}")
	private long jwtExpirationTime;

	public String generateToken(Authentication auth) {
		MekUserDetails userDetails = (MekUserDetails) auth.getPrincipal();
		return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationTime))
				.signWith(SignatureAlgorithm.HS512, jwtSecrectCode).compact();
	}

	public String getUserId(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecrectCode).parseClaimsJws(token).getBody();
		return claims.getSubject().split(",")[0];
	}

	public String getUsername(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecrectCode).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public Date getExpirationDate(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecrectCode).parseClaimsJws(token).getBody();

		return claims.getExpiration();
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecrectCode).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			log.error("Invalid JWT signature - {}", ex.getMessage());
		} catch (MalformedJwtException ex) {
			log.error("Invalid JWT token - {}", ex.getMessage());
		} catch (ExpiredJwtException ex) {
			log.error("Expired JWT token - {}", ex.getMessage());
		} catch (UnsupportedJwtException ex) {
			log.error("Unsupported JWT token - {}", ex.getMessage());
		} catch (IllegalArgumentException ex) {
			log.error("JWT claims string is empty - {}", ex.getMessage());
		}
		return false;
	}
}
