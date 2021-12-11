package com.js.api.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_user")
@Data
@NoArgsConstructor
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "password")
	public String password;

	@Column(name = "phone_number")
	public String phoneNumber;

	@Column(name = "email")
	public String email;

	@Column(name = "first_name")
	public String firstName;

	@Column(name = "last_name")
	public String lastName;

	@Column(name="image_url")
	private String imageURL;
	
	@Column(name = "location")
	public String currentLocation;
	
	@Column(name = "city")
	public String city;
	
	@Column(name = "phone_number2")
	private String phoneNumber2;

	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private UserStatus status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	private Date updatedDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date")
	private Date lastLoginDate;

	@Column(name = "last_login_ip")
	private String lastLoginIp;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "locale")
	private String locale;
	
	@Column(name = "subscriptionId")
	private Long activeSubscriptionId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "subscription_start_date")
	private Date subscriptionStartDate;

	public static enum UserStatus {
		DISABLED, ACTIVE, IN_ACTIVE, BLOCKED
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "mek_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = {
			CascadeType.ALL },targetEntity = UserPreferences.class, mappedBy = "user")
	private Set<UserPreferences> userPreferences = new HashSet<UserPreferences>();
	
}
