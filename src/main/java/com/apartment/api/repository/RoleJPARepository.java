package com.apartment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apartment.api.entities.Role;

@Repository
public interface RoleJPARepository extends JpaRepository<Role, Long>{

	
}
