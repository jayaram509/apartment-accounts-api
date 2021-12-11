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
@Table(name = "mek_user_car")
@Data
@NoArgsConstructor
public class UserCar implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_car_id")
	private Long userCarId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "car_id")
	private Long carId;

	@Column(name = "car_name")
	private String carName;

	@Column(name = "registration_number")
	private String registrationNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registration_date")
	private Date registraionDate;
}
