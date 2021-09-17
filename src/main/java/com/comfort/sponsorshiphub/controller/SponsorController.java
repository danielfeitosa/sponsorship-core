package com.comfort.sponsorshiphub.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import com.comfort.sponsorshiphub.exception.ElementoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.comfort.sponsorshiphub.controller.dto.SponsorDto;
import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.service.SponsorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/api/v1/sponsor")
@RestController
public class SponsorController {
	
	@Autowired 
	private final  SponsorService sponsorService;
	

    @PostMapping
	public Sponsor save(@RequestBody Sponsor sponsor){
		return sponsorService.save(sponsor);
	}
	@GetMapping("/id")
	public Sponsor findById(Long id){
    	return sponsorService.findById(id).orElseThrow(()->new  ElementoNaoEncontrado());
	}

	@GetMapping
	public List<Sponsor> findByName(String name){
    	return sponsorService.findByName(name).orElseThrow(()-> new ElementoNaoEncontrado());
	}



	

}
