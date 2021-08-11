package com.comfort.sponsorshiphub.controller;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comfort.sponsorshiphub.controller.dto.SponsorDto;
import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.service.SponsorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sponsor")
@RestController
public class SponsorController {
	
	@Autowired @Qualifier("sponsorServiceImpl2")
	private final  SponsorService sponsorService;
	
	@PostConstruct
	public void init() {
		 System.out.println("@PostConstruct" + SponsorController.class.getName());
		 System.out.println();
	}
	
	@GetMapping("/{id}")
   public ResponseEntity<SponsorDto> getSponsor(@PathVariable("id") UUID id){
	   Sponsor sponsor =   sponsorService.getSponsor(null);
	   return new ResponseEntity<SponsorDto>(new SponsorDto(sponsor),HttpStatus.OK);
	
   }
}
