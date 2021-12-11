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
@Table(name = "mek_user_subscription")
@Data
@NoArgsConstructor
public class UserSubscription implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_subscription_id")
	private Long userSubscriptionId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "subscription_id")
	private Long subscriptionId;
	
	@Column(name = "active")
	private Boolean active;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

}
