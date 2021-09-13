package com.comfort.sponsorshiphub.repository;

import com.comfort.sponsorshiphub.model.Sponsor;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@DisplayName("Testes as classes do repository do sponsor")
class SponsorRepositoryTest {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Test
    @DisplayName("Sponsor")
    void save_sponsor_whenSuccessful(){

       Sponsor sponsor= this.sponsorRepository.save(create());
       assertEquals("Daniel",sponsor.getFirstName());
       assertEquals("Gomes Feitosa",sponsor.getLastName());
       assertFalse(sponsor.getId()==null);



    }

    private Sponsor create(){
        return Sponsor.builder()
                .firstName("Daniel")
                .lastName("Gomes Feitosa")
                .birthDate(LocalDate.of(1984,12,20))
                .build();
    }
}