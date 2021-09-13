package com.comfort.sponsorshiphub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.comfort.sponsorshiphub.security.SHUserDetails;

public interface SHUserDetailsRepository extends JpaRepository<SHUserDetails, Long> {
	
	Optional<UserDetails> findByEmail(String username);

}
