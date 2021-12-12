package com.apartment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.extern.slf4j.Slf4j;


@SpringBootApplication
@Slf4j
public class AppartmentAPIStarter {

	public static void main(String[] args) {
		log.info("ApartmentAPIstarter started");
		SpringApplication.run(AppartmentAPIStarter.class, args);
	}

}
