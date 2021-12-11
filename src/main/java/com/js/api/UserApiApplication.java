package com.js.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.js.api.entities.ServiceCenterBikes;


@SpringBootApplication
public class UserApiApplication {

	public static void main(String[] args) {
		ServiceCenterBikes sb = new ServiceCenterBikes();
		SpringApplication.run(UserApiApplication.class, args);
	}

}
