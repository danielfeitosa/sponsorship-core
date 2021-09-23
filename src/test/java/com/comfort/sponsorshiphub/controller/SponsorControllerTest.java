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
import java.util.Collections;
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

       BDDMockito.when(service.findAll()).thenReturn( List.of(SponsorCreator.createSponsorSuccess()));
       BDDMockito.when(service.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(SponsorCreator.createSponsorSuccess()));
       BDDMockito.when(service.save(ArgumentMatchers.any())).thenReturn(SponsorCreator.createSponsorSuccess());
       BDDMockito.when(service.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.of(List.of(SponsorCreator.createSponsorSuccess())));
       BDDMockito.doNothing().when(service).update(ArgumentMatchers.any());
    }


    @Test
    @DisplayName("Save a sponsor with success")
    void save_sponsor_WhenSuccessful(){
     Sponsor sponsor= controller.save(ArgumentMatchers.any());
     Assertions.assertThat(sponsor).isNotNull();
     Assertions.assertThat(sponsor).isEqualTo(SponsorCreator.createSponsorSuccess());
    }


    @Test
    @DisplayName("Update a sponsor with success")
    void update_sponsor_WhenSuccessful(){
     Assertions.assertThatCode(()-> controller.update(ArgumentMatchers.any()));
    }


    @Test
    @DisplayName("Find a sponsor from id with success")
    void findById_ReturnSponsor_WhenSuccessful(){
        Long expectId = SponsorCreator.createSponsorSuccess().getId();
        Sponsor sponsor=  controller.findById(ArgumentMatchers.anyLong());
        Assertions.assertThat(sponsor.getId()).isNotNull();
        Assertions.assertThat(sponsor.getId()).isEqualTo(expectId);
        Assertions.assertThat(sponsor.getFirstName()).isEqualTo(SponsorCreator.createSponsorSuccess().getFirstName());

    }


    @Test
    @DisplayName("Find a sponsor from name with success")
    void findByName_ReturnSponsor_WhenSuccessful(){
        Long expectId = SponsorCreator.createSponsorSuccess().getId();
        List<Sponsor> sponsorList=  controller.findByName(ArgumentMatchers.anyString());
        Assertions.assertThat(sponsorList).isNotNull();
    }


    @Test
    @DisplayName("Find a sponsor from name empty list")
    void findByName_EmptyList_WhenSuccessful(){
        BDDMockito.when(service.findByName(ArgumentMatchers.anyString())).thenReturn(Optional.empty());

        List<Sponsor> sponsorList=  controller.findByName(ArgumentMatchers.anyString());
        Assertions.assertThat(sponsorList).isNotNull().isEmpty();
    }





}