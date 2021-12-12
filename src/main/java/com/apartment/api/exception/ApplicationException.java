package com.apartment.api.exception;

import org.springframework.context.MessageSource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationException  extends Exception{

	private static final long serialVersionUID = 1L;
	private MessageSource messageSource;
	private int errorCode;
	private String message;
	private ErrorCode error;
	private String[] args;

	public ApplicationException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public ApplicationException(ErrorCode code, String... args ) {
		super(code.getPlaceholder());
		this.error = code;
		this.errorCode = code.getCode();
		this.args = args;
	}
}
