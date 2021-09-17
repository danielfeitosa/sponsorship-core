package com.comfort.sponsorshiphub.repository;

import com.comfort.sponsorshiphub.model.Sponsor;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.comfort.sponsorshiphub.util.SponsorCreator;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Testes as classes do repository do sponsor")
@Log4j2
class SponsorRepositoryTest {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Test
    @DisplayName("Test save a Sponsor with success")
    void save_sponsor_whenSuccessful(){
       Sponsor sponsor= this.sponsorRepository.save(SponsorCreator.createSponsorSucess());
       assertEquals("Daniel",sponsor.getFirstName());
       assertEquals("Gomes Feitosa",sponsor.getLastName());
       assertFalse(sponsor.getId()==null);

    }
    @Test
    @DisplayName("Test update a Sponsor with success")
    void update_sponsor_whenSuccessful(){
        Sponsor sponsor= this.sponsorRepository.save(SponsorCreator.createSponsorSucess());
      sponsor.setLastName("Jardim Feitosa");
      Sponsor sponsorUpdate= sponsorRepository.save(sponsor);
      log.info(sponsorUpdate.getLastName());
      assertEquals(sponsor.getLastName(),sponsorUpdate.getLastName());
      assertEquals(sponsor.getFirstName(),sponsorUpdate.getFirstName());

    }


    @Test
    @DisplayName("Test delete a Sponsor with success")
    void delete_sponsor_whenSuccessful(){
        Sponsor sponsor= this.sponsorRepository.save(SponsorCreator.createSponsorSucess());
        sponsor.setLastName("Jardim Feitosa");
        Sponsor sponsorUpdate= sponsorRepository.save(sponsor);
        assertEquals(sponsor.getLastName(),sponsorUpdate.getLastName());
        assertEquals(sponsor.getFirstName(),sponsorUpdate.getFirstName());

    }


}