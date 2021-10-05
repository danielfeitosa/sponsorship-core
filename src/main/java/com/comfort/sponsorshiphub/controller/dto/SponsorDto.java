package com.comfort.sponsorshiphub.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.comfort.sponsorshiphub.model.Sponsor;

import io.swagger.v3.oas.annotations.media.Schema;
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
	@Schema(description = "First name Sponsor",defaultValue = "Daniel")
	private String firstName;
	@Schema(description = "Last name Sponsor",defaultValue = "Gomes Feitosa")
	private String lastName;
	@Schema(description = "BithDate Sponsor")
	private LocalDate birthDate;


}
