package com.apartment.api.services;


import com.apartment.api.dto.request.UserRegisterRequest;
import com.apartment.api.dto.request.UserUpdateRequet;
import com.apartment.api.entities.User;
import com.apartment.api.exception.ApplicationException;

public interface UserService {
	
	public User getUserByEmail(String email);
	
	public User getUserByPhone(String phoneNumber);
	
	public User createUser(UserRegisterRequest request) throws ApplicationException;
	
	public User updateUser(UserUpdateRequet requset);
	
	public User authenticateUser(String email,String password);
	
	public User authenticateUserByPhone(String phone,String password);
	
	
}
