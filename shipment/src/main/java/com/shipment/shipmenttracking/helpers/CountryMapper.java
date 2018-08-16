package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.CountryDto;
import com.shipment.shipmenttracking.entities.CountryEntity;
import org.springframework.stereotype.Component;


public class CountryMapper {

    public static CountryDto toDto(CountryEntity countryEntity) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(countryEntity.getId());
        countryDto.setName(countryEntity.getName());
        countryDto.setCode(countryEntity.getCode());

        return countryDto;
    }

    public static CountryEntity toEntity(CountryDto countryDto) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(countryDto.getId());
        countryEntity.setName(countryDto.getName());
        countryEntity.setCode(countryDto.getCode());

        return countryEntity;
    }
}
