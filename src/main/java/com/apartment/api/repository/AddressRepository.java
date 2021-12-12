package com.apartment.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apartment.api.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
