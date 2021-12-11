package com.js.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
