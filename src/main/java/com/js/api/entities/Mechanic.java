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
@Table(name = "mek_mechanic")
@Data
@NoArgsConstructor
public class Mechanic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "mechanid_id")
	private Long mechanicId;

	private String name;

	@Column(name = "experience")
	private String experience;

	@Column(name = "rating")
	private Double rating;
	
	
}
