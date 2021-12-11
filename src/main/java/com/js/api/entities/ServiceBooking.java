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
@Table(name="mek_service_booking")
@Data
@NoArgsConstructor
public class ServiceBooking implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="service_booking_id")
	private Long serviceBookingId;
	
	private Long bookingId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="details")
	private String details;
	

}
