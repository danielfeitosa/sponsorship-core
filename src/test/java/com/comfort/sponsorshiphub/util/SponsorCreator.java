package com.comfort.sponsorshiphub.util;

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
}
