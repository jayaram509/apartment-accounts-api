package com.js.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_user_bike")
@Data
@NoArgsConstructor
public class UserBike implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_bike_id")
	private Long userBikeId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "bike_id")
	private Long bikeId;

	@Column(name = "bike_name")
	private String bikeName;

	@Column(name = "registration_number")
	private String registrationNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_date")
	private Date registraionDate;
}
