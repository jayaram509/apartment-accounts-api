package com.js.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.api.entities.BikeDetails;

public interface BikeDetailsRepository extends JpaRepository<BikeDetails, Long> {

}
