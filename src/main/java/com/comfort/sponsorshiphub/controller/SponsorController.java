package com.comfort.sponsorshiphub.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.comfort.sponsorshiphub.controller.dto.SponsorDto;
import com.comfort.sponsorshiphub.mapper.SponsorMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final SponsorMapper sponsorMapper;

    @PostMapping
	@Operation(summary = "Save a sponsor" , description = "Save all data of a sponsor")
	public SponsorDto save(@RequestBody SponsorDto dto){
    	return sponsorMapper.entityToDto(sponsorService.save(sponsorMapper.dtoToEntity(dto)));
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find a Sponsor by Id" , description = "Find a Sponsor by Id")
	public SponsorDto findById(@PathVariable Long id){
    	return sponsorMapper.entityToDto( sponsorService.findById(id).orElseThrow(()->new  ElementoNaoEncontrado()));
	}

	@GetMapping
	@Operation(summary = "Find all Sponsor " , description = "Find all Sponsor")
	public List<SponsorDto> findAll(){
		return sponsorService.findAll().stream().map(sponsor -> sponsorMapper.entityToDto(sponsor)).collect(Collectors.toList());
	}

	@GetMapping("/name/{name}")
	public List<Sponsor> findByName(String name){
    	return sponsorService.findByName(name).orElse(Collections.emptyList());
	}

	@PutMapping
	public ResponseEntity<Void> update(@RequestBody SponsorDto dto){

    	sponsorService.update(sponsorMapper.dtoToEntity(dto));
    	return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
   @Operation(summary = "delete sponsor by id")

	public  ResponseEntity<Void> delete(@PathVariable Long id){
    	sponsorService.delete(id);
		return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
	}



	

}
