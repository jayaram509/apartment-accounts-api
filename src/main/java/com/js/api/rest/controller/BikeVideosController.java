package com.js.api.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bike/v1")
public class BikeVideosController {

	@GetMapping("/videos")
	public ResponseEntity<?> getAllVideos(){
		System.out.println("test videos");
		return ResponseEntity.ok("succes");
	}
}
