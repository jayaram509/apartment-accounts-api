package com.js.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_bike_videos")
@Data
@NoArgsConstructor
public class BikeVideo  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bike_video_id")
	private Long bikeVideoId;

	@Column(name = "bike_id")
	private Long bikeId;

	@Column(name = "bike_name")
	private String bikeName;

	@Column(name = "bike_details")
	private String bikeDetails;

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
