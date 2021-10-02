package com.comfort.sponsorshiphub.util;

import com.comfort.sponsorshiphub.controller.dto.SponsorDto;
import com.comfort.sponsorshiphub.model.Sponsor;

import java.time.LocalDate;

public class SponsorCreator {



    public static Sponsor createSponsorSuccess(){
        return Sponsor.builder()
                .id(1L)
                .firstName("Daniel")
                .lastName("Gomes Feitosa")
                .birthDate(LocalDate.of(1984,12,20))
                .build();
    }

    public static SponsorDto createSponsorDtoSuccess(){
        return SponsorDto.builder()
                .id(1L)
                .firstName("Daniel")
                .lastName("Gomes Feitosa")
                .birthDate(LocalDate.of(1984,12,20))
                .build();
    }
}
