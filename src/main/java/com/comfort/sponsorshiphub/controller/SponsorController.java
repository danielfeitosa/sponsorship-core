package com.comfort.sponsorshiphub.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comfort.sponsorshiphub.exception.ElementoNaoEncontrado;
import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.service.SponsorService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/sponsor")
@RestController
public class SponsorController {
	

	private final  SponsorService sponsorService;


    @PostMapping
	public Sponsor save(@RequestBody Sponsor sponsor){
		return sponsorService.save(sponsor);
	}
	@GetMapping("/{id}")
	public Sponsor findById(@PathVariable Long id){
    	return sponsorService.findById(id).orElseThrow(()->new  ElementoNaoEncontrado());
	}

	@GetMapping("/name/{name}")
	public List<Sponsor> findByName(String name){
    	return sponsorService.findByName(name).orElse(Collections.emptyList());
	}

	@PutMapping
	public void update(@RequestBody Sponsor sponsor){
    	 sponsorService.update(sponsor);
	}



	

}
