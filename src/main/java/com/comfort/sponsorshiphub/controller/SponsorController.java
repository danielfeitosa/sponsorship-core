package com.comfort.sponsorshiphub.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.comfort.sponsorshiphub.service.SponsorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SponsorController {
	
	@PostConstruct
	public void init() {
		 System.out.println("@PostConstruct" + SponsorController.class.getName());
	}
	
	@Autowired @Qualifier("sponsorServiceImpl2")
	private SponsorService sponsorService;
	
	
	public void addSponsor() {
	    sponsorService.getSponsor(1L);
	}
	
	public String sayHello() {
	    return sponsorService.sayHelloSponsor();
	}
	

}
