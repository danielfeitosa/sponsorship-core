package com.comfort.sponsorshiphub.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.comfort.sponsorshiphub.service.SponsorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class SponsorController2 {
	
	@PostConstruct
	public void init() {
		 System.out.println("@PostConstruct" + SponsorController2.class.getName());
	}
	
	@Autowired 
	private SponsorService sponsorService;
	
	
	public void addSponsor() {
	    sponsorService.getSponsor(1L);
	}
	
	public String sayHello() {
	    return sponsorService.sayHelloSponsor();
	}
	@PreDestroy
	public void destroy() {
		System.out.println("@PreDestroy" + SponsorController2.class.getName());
	}
	

}
