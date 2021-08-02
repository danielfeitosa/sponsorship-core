package com.comfort.sponsorshiphub;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comfort.sponsorshiphub.service.SponsorService;
@SpringBootTest
public class SponsorServiceTest {
	
	@Autowired
	private SponsorService sponsorService;
	
	@BeforeEach
	public void setUp() {
		
		System.out.println("execute initial command!!");
		
	}
	
	
	@Test
	public void testar() {
		
		assertTrue(sponsorService.sayHelloSponsor() != null);
		
		
		
	}
	
	
	@Test
	public void testar2() {
		
		assertTrue(sponsorService.sayHelloSponsor().equals("Hello Sponsor: Hoje vamos  "));
		
		
		
	}

}
