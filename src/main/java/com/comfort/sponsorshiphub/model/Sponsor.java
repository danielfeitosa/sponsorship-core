package com.comfort.sponsorshiphub.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@NoArgsConstructor


public class Sponsor extends BaseEntity {
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
    @Builder
	public Sponsor(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate) {
		super(id, version, createdDate, lastModifiedDate);
	
	}
	
	

}
