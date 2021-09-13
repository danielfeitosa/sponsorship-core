package com.comfort.sponsorshiphub.service;

import java.time.LocalDate;
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
	public Sponsor getSponsor(Long idSponsor) {

		return Sponsor.builder()
				.id(UUID.randomUUID())
				.firstName("Daniel")
				.birthDate(LocalDate.of(1984, 12, 20))
				.lastName("Feitosa")
				.build();
	}

	@Override
	public String sayHelloSponsor() {

		return "Hello Sponsor: Hoje vamos  ";
	}

	@Override
	public Sponsor save() {
		// TODO Auto-generated method stub
		return null;
	}

}
