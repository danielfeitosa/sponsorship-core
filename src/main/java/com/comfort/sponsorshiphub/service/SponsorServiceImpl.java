package com.comfort.sponsorshiphub.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.comfort.sponsorshiphub.model.Sponsor;
@Service  @Primary
public class SponsorServiceImpl implements SponsorService {

	@Override
	public Sponsor getSponsor(Long idSponsor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHelloSponsor() {
		
		return  "Hello Sponsor";
	}

}
