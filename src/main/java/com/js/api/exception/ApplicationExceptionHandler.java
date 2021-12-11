package com.js.api.exception;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.js.api.dto.response.ApplicationResponse;


@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	public MessageSource messageSource;

	@ExceptionHandler(ApplicationException.class)
	public final ResponseEntity<Object> applicationException(ApplicationException ex, WebRequest request) {
		String message = null;
		int errorCode = 500;
		if (ex.getError() != null) {
			message = messageSource.getMessage(ex.getError().getPlaceholder(), ex.getArgs(), Locale.ENGLISH);
			errorCode = ex.getError().getCode();
		} else {
			message = ex.getMessage();
		}
		ApplicationResponse res = ApplicationResponse.builder().timestamp(new Date()).status(500).errorCode(errorCode)
				.errorMessage(message).message(message).build();
		return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<Object> userNameNotFoundException(AuthenticationException ex, WebRequest request) {
		ApplicationResponse res = ApplicationResponse.builder().timestamp(new Date()).status(500).errorCode(404)
				.errorMessage(messageSource.getMessage("user.invalid.login.id", null,Locale.ENGLISH)).message(ex.getMessage()).build();
		return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
	}
	
}
