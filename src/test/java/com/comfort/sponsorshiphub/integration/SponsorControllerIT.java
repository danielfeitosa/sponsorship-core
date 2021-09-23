package com.comfort.sponsorshiphub.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.repository.SponsorRepository;
import com.comfort.sponsorshiphub.util.SponsorCreator;

import lombok.extern.log4j.Log4j2;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
@Log4j2
public class SponsorControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private  int port;
    
    @Autowired
    private SponsorRepository repository;
    
    private Sponsor sponsor;
    
    @BeforeEach
    void setUp() {
    	
    	sponsor=repository.save(SponsorCreator.createSponsorSuccess());
    	
    }
    

    @Test
    @DisplayName("Find a sponsor from id with success")
    void findById_ReturnSponsor_WhenSuccessful(){
    	String  SERV ="http://localhost:" + port;
    	log.info(SERV+"/sponsor/1");
        ResponseEntity<Sponsor> response= testRestTemplate.getForEntity(SERV+"/sponsor/"+sponsor.getId(), Sponsor.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    }

}
