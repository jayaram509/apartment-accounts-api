package com.js.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.js.api.entities.User;
import com.js.api.repository.UserJPARepository;
import com.js.api.sercurity.MekUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserJPARepository userJPAReposiroty;
	
	@Value("${application.redis.cache.enabled}")
	private Boolean isRedisEnabled;
	

	@Override
	public UserDetails loadUserByUsername(String userName) throws AuthenticationException {
	    if(StringUtils.isNotBlank(userName)) {
	    	boolean isEmail = userName.contains("@");
	    	User user = null;
	    	if(!isRedisEnabled) {
	    		if(isEmail) {
		    		user  = userJPAReposiroty.findByEmail(userName);
		    	}else {
		    		user = userJPAReposiroty.findByPhoneNumber(userName);
		    	}
				if (user == null ) {
					log.error("1001-User not found:"+userName);
					throw new UsernameNotFoundException(String.format("User not existed with given %s", userName));
				}
				List<GrantedAuthority> authorities = user.getRoles().stream()
						.map(role -> new SimpleGrantedAuthority(role.getName().name()))
						.collect(Collectors.toList());
				MekUserDetails mekUser = new MekUserDetails(user.getEmail(),user.getEmail(), user.getPhoneNumber(), user.getPassword(),user.getUserId(),authorities);
				return mekUser;
	    	}else {
	    		return null; // replace with redis system
	    	}
			
	    }
	    return null;
		
	}
}
