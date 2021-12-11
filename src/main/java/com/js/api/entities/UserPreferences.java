package com.js.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_user_preferences")
@Data
@NoArgsConstructor
public class UserPreferences implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_preferences_id")
	private Long userPrefrencesId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	@Enumerated
	@Column(name = "preference_type")
	private PreferanceType preferenceType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "preference_value")
	private String value;

	public static enum PreferanceType {
		FAVOURITE_VIDEOS("FAVOURITE_VIDEOS"), FAVOURITE_SERVICE_CENTER("FAVOURITE_SERVICE_CENTER"),
		FAVOURITE_MECHANIC("FAVOURITE_MECHANIC"), FAVOURITE_BLOG("FAVOURITE_BLOG");

		private String value;

		PreferanceType(String value) {
			this.setValue(value);
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}