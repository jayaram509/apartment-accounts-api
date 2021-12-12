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
@Table(name = "apt_offers")
@Data
@NoArgsConstructor
public class Offers implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "offers_id")
	private Long offersId;

	@Column(name = "offers_name")
	private String offersName;

	@Column(name = "details")
	private String details;

	@Column(name="image_url")
	private String imageURL;

	@Column(name = "active")
	private Boolean isActive;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiry_date")
	private Date expirayDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

}
