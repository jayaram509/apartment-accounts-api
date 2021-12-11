package com.js.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_auth_token")
@Data
@NoArgsConstructor
public class AuthToken implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "token_id")
	private Long tokenId;
	
	@Column(name="token")
	private String token;
	
	@Column(name="expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="allow_expire")
	private Boolean allowExipre;
	
	@Column(name="user_id")
	private Long userId;
}
