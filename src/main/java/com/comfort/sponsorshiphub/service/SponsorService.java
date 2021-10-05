package com.comfort.sponsorshiphub.service;

import java.util.List;
import java.util.Optional;

import com.comfort.sponsorshiphub.model.Sponsor;

public interface SponsorService {
	

	
	Sponsor save(Sponsor sponsor);

	void update(Sponsor sponsor);

	List<Sponsor> findAll();

	Optional<Sponsor> findById(Long idSponsor);

	Optional<List<Sponsor>> findByName(String name);

	void delete(Long id);


}
