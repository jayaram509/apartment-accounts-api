package com.apartment.api.sercurity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class MekUserDetails implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	@JsonIgnore
	private String password;
	private String role;
	private Long userId;
	private String phoneNumber;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public MekUserDetails(String userName,String email,String phoneNumber, String password,Long userId,List<GrantedAuthority> authorities) {
		super();
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.userName = userName;
		this.authorities = authorities;
	}

	public MekUserDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
