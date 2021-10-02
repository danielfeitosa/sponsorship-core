package com.comfort.sponsorshiphub.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.comfort.sponsorshiphub.model.Sponsor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SponsorDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;


}
