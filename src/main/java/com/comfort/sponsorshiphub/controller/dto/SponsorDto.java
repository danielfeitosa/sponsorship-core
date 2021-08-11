package com.comfort.sponsorshiphub.controller.dto;

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
	
	private UUID uuid;
	private String firstName;
	private String lastName;
	
	public SponsorDto(Sponsor sponsor) {
		this.uuid = sponsor.getId();
		this.firstName =sponsor.getFirstName();
		this.lastName = sponsor.getLastName();
		
	}

}
