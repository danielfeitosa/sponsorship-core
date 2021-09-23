package com.comfort.sponsorshiphub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.comfort.sponsorshiphub.security.SHUserDetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@RequiredArgsConstructor
@Profile({"dev"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final SHUserDetailsService userDetailsService;
	@Value("${spring.profiles.active}")
	private String profile;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable();
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    if(profile.equals("test")) {
	    	http.authorizeRequests().antMatchers("**").permitAll().anyRequest().authenticated();
	    }else {
	    	http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	    }
	    
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		User.UserBuilder user1 = User.builder().username("daniel").password("{noop}teste").roles("USER");
		  auth.inMemoryAuthentication().withUser(user1);
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		log.info("teste");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	

	

}
