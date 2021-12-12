package com.apartment.api.entities;

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
@Table(name = "apt_user_device")
@Data
@NoArgsConstructor
public class UserDevice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_device_id")
	private Long userDeviceId;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "device_name")
	private String deviceName;

	@Column(name = "device_model")
	private String deviceModel;

	@Column(name = "device_uuid")
	private String deviceUUID;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	

}
