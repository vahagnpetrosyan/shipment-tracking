package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.CountryDto;
import com.shipment.shipmenttracking.entities.CountryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    @Autowired
    ModelMapper modelMapper;

    public  CountryDto toDto(CountryEntity countryEntity) {
        return this.modelMapper.map(countryEntity, CountryDto.class);
    }

    public CountryEntity toEntity(CountryDto countryDto) {
        return this.modelMapper.map(countryDto, CountryEntity.class);
    }
}
