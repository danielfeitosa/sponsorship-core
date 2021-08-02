package com.comfort.sponsorshiphub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.comfort.sponsorshiphub.component.Component;
import com.comfort.sponsorshiphub.component.ComponentMobile;
import com.comfort.sponsorshiphub.component.ComponentUtil;

@Configuration
public class BeanConfig {
	
	@Profile("WEB")
	@Bean
	Component componentUtil() {
		return new ComponentUtil();
	}
	
	@Profile("MOBILE")
	@Bean
	Component componentMobile() {
		return new ComponentMobile();
	}
	
	
	
	
	

}
