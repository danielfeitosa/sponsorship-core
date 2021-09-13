package com.comfort.sponsorshiphub.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.comfort.sponsorshiphub.service.SponsorService;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final SponsorService service;
	
	
	public BootStrapData(SponsorService service) {
		this.service = service;
	}
	
	

	@Override
	public void run(String... args) throws Exception {
	
	
		
	}

}
