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
@Table(name = "apt_subscription")
@Data
@NoArgsConstructor
public class Subscription implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscription_id")
	private Long subscriptionId;

	@Column(name = "plan_name")
	private String planName;
	
	@Column(name = "cost")
	private Double cost;

	@Column(name = "rate_plan")
	private String ratePlan;
	
	@Column(name="image_url")
	private String imageURL;

	@Column(name = "description")
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
}
