package com.comfort.sponsorshiphub.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.comfort.sponsorshiphub.repository.SHUserDetailsRepository;
import com.comfort.sponsorshiphub.security.SHUserDetails;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class LoadUserConfig {
	@Autowired
	private final SHUserDetailsRepository userRepository;
    @Autowired
	private final PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() {

		SHUserDetails shUser = SHUserDetails.builder().email("daniel@gmail.com")
				.password(passwordEncoder.encode("teste")).authorities("ADMIN,USER").build();
		
		userRepository.save(shUser);

	}

}
