package com.apartment.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "apt_city")
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class City {

	@Id 	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "city_id")
	private Long cityId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "active")
	private Boolean active;
	
}
