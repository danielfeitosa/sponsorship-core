package com.comfort.sponsorshiphub.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.comfort.sponsorshiphub.repository.SHUserDetailsRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class SHUserDetailsService implements UserDetailsService {
	
	
	private final SHUserDetailsRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("Usuário não foi encontrado"));
	}

}
