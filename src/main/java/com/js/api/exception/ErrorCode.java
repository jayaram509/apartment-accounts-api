package com.js.api.exception;


public enum ErrorCode {

	USER_NOT_FOUND(1001,"user.not.found"),
	USER_EMAIL_ALREADY_EXIST(1002,"user.email.already.exists");

	private int code;
	private String placeholder;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	ErrorCode(int code, String description) {
		this.code = code;
		this.placeholder = description;
	}
	
}
