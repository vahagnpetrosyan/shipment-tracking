package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.CountryDto;
import com.shipment.shipmenttracking.entities.CountryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CountryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public  Mono<CountryDto> toDtoMono(Mono<CountryEntity> countryEntityMono) {
        return countryEntityMono.map(this::toDto);
    }

    public Mono<CountryEntity> toEntityMono(Mono<CountryDto> countryDtoMono) {
        return countryDtoMono.map(this::toEntity);
    }

    public Flux<CountryDto> toDtoFlux(Flux<CountryEntity> countryEntityFlux) {
        return countryEntityFlux.map(this::toDto);
    }

    public Flux<CountryEntity> toFluxEntity(Flux<CountryDto> countryDtoFlux) {
        return countryDtoFlux.map(this::toEntity);
    }

    public CountryDto toDto(CountryEntity countryEntity) {
        return this.modelMapper.map(countryEntity, CountryDto.class);
    }

    public CountryEntity toEntity(CountryDto countryDto) {
        return this.modelMapper.map(countryDto, CountryEntity.class);
    }
}
