package com.js.api.services;


import com.js.api.dto.request.UserRegisterRequest;
import com.js.api.dto.request.UserUpdateRequet;
import com.js.api.entities.User;
import com.js.api.exception.ApplicationException;

public interface UserService {
	
	public User getUserByEmail(String email);
	
	public User getUserByPhone(String phoneNumber);
	
	public User createUser(UserRegisterRequest request) throws ApplicationException;
	
	public User updateUser(UserUpdateRequet requset);
	
	public User authenticateUser(String email,String password);
	
	public User authenticateUserByPhone(String phone,String password);
	
	
}
