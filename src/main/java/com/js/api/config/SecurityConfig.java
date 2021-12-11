package com.js.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.js.api.sercurity.AuthentionExceptionHandler;
import com.js.api.sercurity.JWTFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthentionExceptionHandler authExceptionHandler;

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public JWTFilter getJWTFilter() {
		return new JWTFilter();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}

	/*
	 * @Bean public AuthenticationProvider daoAuthenticationProvider() {
	 * DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	 * provider.setPasswordEncoder(getPasswordEncoder());
	 * provider.setUserDetailsService(this.userDetailsService); return provider; }
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http = http.cors().and().csrf().disable();
		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();
		http = http.exceptionHandling().authenticationEntryPoint(authExceptionHandler).and();
		// Set permissions on endpoints / Our public endpoints
		http.authorizeRequests().antMatchers("/mobile/api/user/v1/**").permitAll()
				.anyRequest().authenticated();

		// Add JWT token filter
		http.addFilterBefore(getJWTFilter(), UsernamePasswordAuthenticationFilter.class);
		/*
		 * http.cors().and().csrf().disable().exceptionHandling().and().
		 * sessionManagement()
		 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		 * .authorizeRequests().antMatchers("/mobile/api/**").permitAll()
		 * .antMatchers("/api/test/**").permitAll() .anyRequest().authenticated();
		 */
	}

}
