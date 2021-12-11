package com.js.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.js.api.entities.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	public User findByPhoneNumber(String phoneNumber);
}
