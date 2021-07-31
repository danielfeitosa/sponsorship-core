package com.comfort.sponsorshiphub.service;

import com.comfort.sponsorshiphub.model.Sponsor;

public interface SponsorService {
	
	Sponsor getSponsor(Long idSponsor);
	
	String sayHelloSponsor();

}
