package com.apartment.api.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.apartment.api.dto.request.UserRegisterRequest;
import com.apartment.api.dto.request.UserUpdateRequet;
import com.apartment.api.entities.Role;
import com.apartment.api.entities.User;
import com.apartment.api.entities.Role.SystemRole;
import com.apartment.api.exception.ApplicationException;
import com.apartment.api.exception.ErrorCode;
import com.apartment.api.repository.RoleJPARepository;
import com.apartment.api.repository.UserJPARepository;
import com.apartment.api.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserJPARepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleJPARepository roleRepository;
	
	@Override
	public User getUserByEmail(String email) {
		User user = null;
		if (StringUtils.isNotBlank(email)) {
			user = userRepository.findByEmail(email);
		}
		return user;
	}

	@Override
	public User getUserByPhone(String phoneNumber) {
		User user = null;
		if (StringUtils.isNotBlank(phoneNumber)) {
			user = userRepository.findByPhoneNumber(phoneNumber);
		}
		return user;
	}

	public void checkIfUserExists(UserRegisterRequest request) throws ApplicationException {
		if(getUserByEmail(request.getEmail())!=null) {
			throw new ApplicationException(ErrorCode.USER_EMAIL_ALREADY_EXIST,request.getEmail());
		}
		if(getUserByPhone(request.getPhoneNumber())!=null) {
			throw new ApplicationException(ErrorCode.USER_EMAIL_ALREADY_EXIST);
		}
	}
	@Override
	@Transactional
	public User createUser(UserRegisterRequest request) throws ApplicationException {
		checkIfUserExists(request);
		User user = new User();
		user.setCreatedDate(new Date());
		user.setUpdatedDate(new Date());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		
		List<Role> roles = roleRepository.findAll();
		if(roles!=null && !roles.isEmpty()) {
			SystemRole systemRole = SystemRole.getRoleFromInput(request.getRole());
			Optional<Role> roleData = roles.stream().filter(role->role.getName().equals(systemRole)).findFirst();
			if(roleData.isPresent()) {
				//user.getRoles().add(roleData.get());
			}
		}
		return userRepository.save(user);
	}


	@Override
	public User authenticateUser(String email, String password) {
		User user = getUserByEmail(email);
		if(user!=null && passwordEncoder.matches(password, user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User authenticateUserByPhone(String phone, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(UserUpdateRequet requset) {
		// TODO Auto-generated method stub
		return null;
	}

}
