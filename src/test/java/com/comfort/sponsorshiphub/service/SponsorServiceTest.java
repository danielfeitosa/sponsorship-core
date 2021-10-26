package com.comfort.sponsorshiphub.service;

import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.repository.SponsorRepository;
import com.comfort.sponsorshiphub.util.SponsorCreator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Test;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
class SponsorServiceTest {

    @InjectMocks
    SponsorServiceImpl service;
   @Mock
   SponsorRepository repository;

   private Sponsor sponsor;

   @BeforeEach
    void setUp(){
       sponsor = SponsorCreator.createSponsorSuccess();
       BDDMockito.when(repository.save(sponsor)).thenReturn(sponsor);
       BDDMockito.when(repository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(sponsor));
   }

  // @Test
   @DisplayName("Test when save sponsor with successful")
   void testSaveSponsor_when_Successful(){
      Sponsor sponsorReturn= service.save(sponsor);
      Assertions.assertThat(sponsorReturn).isNotNull();
      Assertions.assertThat(sponsorReturn.getId()).isNotNull();
      Assertions.assertThat(sponsorReturn.getFirstName()).isEqualTo(sponsor.getFirstName());

   }
  // @Test
   @DisplayName("Test when update sponsor with successful")
   void test_update_when_successful(){
      Sponsor sponsorFound= service.findById(sponsor.getId()).orElseThrow();
      sponsorFound.setLastName("Jardim");
      Sponsor sponsorUpdated= service.save(sponsorFound);
      Assertions.assertThat(sponsorUpdated).isNotNull();
      Assertions.assertThat(sponsorUpdated.getId()).isNotNull();
      Assertions.assertThat(sponsorUpdated.getLastName()).isEqualTo(sponsorFound.getLastName());

   }
  // @Test
   @DisplayName("Test findbyId method when success case")
   void test_findById_when_successful(){
    Sponsor sponsorFound=   service.findById(ArgumentMatchers.anyLong()).orElseThrow();
    Assertions.assertThat(sponsorFound.getId()).isNotNull().isEqualTo(sponsor.getId());
    Assertions.assertThat(sponsorFound.getFirstName()).isEqualTo(sponsor.getFirstName());
   }







}