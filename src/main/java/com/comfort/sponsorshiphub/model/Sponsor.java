package com.comfort.sponsorshiphub.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sponsor {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;

}
