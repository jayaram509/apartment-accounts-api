package com.js.api.entities;

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
@Table(name="mek_service_center")
@Data
@NoArgsConstructor
public class ServiceCenter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="service_center_id")
	private Long serviceCenterId;

	@Column(name="name")
	private String name;

	@Column(name="details")
	private String details;

	@Column(name="registered_name")
	private String registeredName;
	
	@Column(name="location")
	private String location;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_time")
	private Date endTime;
	
	
	
 
}
