package com.comfort.sponsorshiphub.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.repository.SponsorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SponsorServiceImpl implements SponsorService {

	private SponsorRepository repository;


	@Override
	public Sponsor save(Sponsor sponsor) {

		return repository.save(sponsor);
	}

	@Override
	public void update(Sponsor sponsor) {
		repository.save(sponsor);
	}

	@Override
	public List<Sponsor> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Sponsor> findById(Long idSponsor) {
		return repository.findById(idSponsor);
	}

	@Override
	public Optional<List<Sponsor>> findByName(String name) {
		return repository.findByFirstName(name);
	}

}
