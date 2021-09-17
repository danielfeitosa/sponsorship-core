package com.comfort.sponsorshiphub.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.comfort.sponsorshiphub.model.Sponsor;

public interface SponsorService {
	

	
	String sayHelloSponsor();
	
	Sponsor save(Sponsor sponsor);

	List<Sponsor> findAll();

	Optional<Sponsor> findById(Long idSponsor);

	Optional<List<Sponsor>> findByName(String name);


}
