package com.js.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.api.entities.Bike;

public interface BikeRepository extends JpaRepository<Bike, Long>{

}
