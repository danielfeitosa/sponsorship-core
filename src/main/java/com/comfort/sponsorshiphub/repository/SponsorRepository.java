package com.comfort.sponsorshiphub.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comfort.sponsorshiphub.model.Sponsor;

public interface SponsorRepository extends JpaRepository<Sponsor, UUID> {

}
