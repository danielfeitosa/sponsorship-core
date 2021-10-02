package com.comfort.sponsorshiphub.mapper;

import com.comfort.sponsorshiphub.controller.dto.SponsorDto;
import com.comfort.sponsorshiphub.model.Sponsor;
import org.mapstruct.Mapper;

@Mapper
public interface SponsorMapper {

    SponsorDto entityToDto(Sponsor sponsor);
    Sponsor dtoToEntity(SponsorDto sponsorDto);

}
