package com.comfort.sponsorshiphub.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@AllArgsConstructor
@Builder

public class Sponsor extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	@Builder
	public Sponsor(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate) {
		super(id, version, createdDate, lastModifiedDate);
	
	}
	
	

}
