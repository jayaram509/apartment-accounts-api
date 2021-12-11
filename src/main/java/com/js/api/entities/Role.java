package com.js.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mek_role")
@Data
@NoArgsConstructor
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	private Long roleId;

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	private SystemRole name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<User> users;

	public static enum SystemRole {
		ADMIN("ADMIN"), END_USER("END_USER"), MECHANIC("MECHANIC"), SERVICE_CENTER_ADMIN("SERVICE_CENTER_ADMIN");

		private String roleName;

		SystemRole(String name) {
			this.setRoleName(name);
		}

		public String getRoleName() {
			return roleName;
		}

		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}

		public static SystemRole getRoleFromInput(String value) {
			for (SystemRole role : SystemRole.values()) {
				if (role.getRoleName().equalsIgnoreCase(value)) {
					return role;
				}
			}
			return SystemRole.END_USER;
		}

	}
}
