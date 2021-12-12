package com.apartment.api.dto.response;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponse {

	private int status;
	private Date timestamp;
	private String message;
	private int errorCode;
	private String errorMessage;
	private Object data;
	
}
