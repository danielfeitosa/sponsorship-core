package com.comfort.sponsorshiphub.service;

import java.util.UUID;

import com.comfort.sponsorshiphub.model.Sponsor;

public interface SponsorService {
	
	Sponsor getSponsor(UUID idSponsor);
	
	String sayHelloSponsor();
	
	Sponsor save();

}
