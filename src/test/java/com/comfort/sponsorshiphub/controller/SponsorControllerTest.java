package com.comfort.sponsorshiphub.controller;

import com.comfort.sponsorshiphub.model.Sponsor;
import com.comfort.sponsorshiphub.service.SponsorService;
import com.comfort.sponsorshiphub.util.SponsorCreator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class SponsorControllerTest {

   @InjectMocks
   private SponsorController controller;
   @Mock
   private SponsorService service;


    @BeforeEach
    void setUp(){

       BDDMockito.when(service.findAll()).thenReturn( List.of(SponsorCreator.createSponsorSucess()));
       BDDMockito.when(service.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(SponsorCreator.createSponsorSucess()));
       BDDMockito.when(service.save(ArgumentMatchers.any())).thenReturn(SponsorCreator.createSponsorSucess());
       BDDMockito.when(service.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.of(List.of(SponsorCreator.createSponsorSucess())));

    }

    @Test
    @DisplayName("Save a sponsor with success")
    void save_sponsor_WhenSuccessful(){
     Sponsor sponsor= controller.save(ArgumentMatchers.any());
     Assertions.assertThat(sponsor).isNotNull();
     Assertions.assertThat(sponsor.getFirstName()).isEqualTo(SponsorCreator.createSponsorSucess().getFirstName());

    }
    @Test
    @DisplayName("Find a sponsor from id with success")
    void findById_ReturnSponsor_WhenSuccessful(){
        Long expectId = SponsorCreator.createSponsorSucess().getId();
        Sponsor sponsor=  controller.findById(ArgumentMatchers.anyLong());
        Assertions.assertThat(sponsor.getId()).isNotNull();
        Assertions.assertThat(sponsor.getId()).isEqualTo(expectId);
        Assertions.assertThat(sponsor.getFirstName()).isEqualTo(SponsorCreator.createSponsorSucess().getFirstName());

    }


    @Test
    @DisplayName("Find a sponsor from name with success")
    void findByName_ReturnSponsor_WhenSuccessful(){
        Long expectId = SponsorCreator.createSponsorSucess().getId();
        List<Sponsor> sponsorList=  controller.findByName(ArgumentMatchers.anyString());
        Assertions.assertThat(sponsorList).isNotNull();


    }





}