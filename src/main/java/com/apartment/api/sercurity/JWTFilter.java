package com.apartment.api.sercurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	/*
	 * @Autowired private AuthenticationService authenticationService;
	 */

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		// Get authorization header and validate
		final String header = ((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.isEmpty(header) || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response);
			return;
		}

		// Get jwt token and validate
		final String token = header.split(" ")[1].trim();
		if (!jwtTokenUtil.validate(token)) {
			chain.doFilter(request, response);
			return;
		}

		String username = jwtTokenUtil.getUsername(token);

		UserDetails userDetails = null;//authenticationService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails((HttpServletRequest) request));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

}
