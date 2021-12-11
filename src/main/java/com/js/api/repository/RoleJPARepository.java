package com.js.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.js.api.entities.Role;

@Repository
public interface RoleJPARepository extends JpaRepository<Role, Long>{

	
}
