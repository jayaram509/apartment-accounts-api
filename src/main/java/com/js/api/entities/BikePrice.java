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
@Table(name="mek_bike_price")
@Data
@NoArgsConstructor
public class BikePrice  implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bike_price_id")
	private Long bikePriceId;
	
	@Column(name="bike_id")
	private Long bikeId;
	
	@Column(name="show_room_price")
	private Double showRoomPrice;
	
	@Column(name="on_road_price")
	private Double onRoadPrice;
	
	@Column(name="location")
	private String location;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
}
