package com.comfort.sponsorshiphub.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Sponsor {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;

}
