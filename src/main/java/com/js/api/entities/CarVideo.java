package com.js.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_car")
@Data
@NoArgsConstructor
public class CarVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "car_video_id")
	private Long carVideoId;

	@Column(name = "car_id")
	private Long carId;
	
	@Column(name = "car_name")
	private String carName;

	@Column(name = "car_details")
	private String carDetails;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "video_url")
	private String videoUrl;

	@Column(name = "thumbnail_url")
	private String thumbnail_url;

	@Column(name = "is_free")
	private boolean isFreeVideo;

	@Column(name = "views_count")
	private Long viewsCount;
}
