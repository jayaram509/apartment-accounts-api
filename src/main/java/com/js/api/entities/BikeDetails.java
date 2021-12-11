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
@Table(name="mek_bike_details")
@Data
@NoArgsConstructor
public class BikeDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bike_details_id")
	private Long bikeDetailsId;
	
	@Column(name="bike_id")
	private Long bikeId;
	
	@Column(name="specifications")
	private String specification;

}
