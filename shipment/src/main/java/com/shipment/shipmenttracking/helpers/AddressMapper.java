package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.AddressDto;
import com.shipment.shipmenttracking.entities.AddressEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AddressMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Mono<AddressDto> toDtoMono(Mono<AddressEntity> addressEntityMono){
        return addressEntityMono.map(this::toDto);
    }

    public Mono<AddressEntity> toEntityMono(Mono<AddressDto> addressDtoMono) {
        return addressDtoMono.map(this::toEntity);
    }

    public Flux<AddressDto> toDtoFlux(Flux<AddressEntity> addressEntityFlux) {
        return addressEntityFlux.map(this::toDto);
    }

    public Flux<AddressEntity> toEntityFlux(Flux<AddressDto> addressDtoFlux){
        return addressDtoFlux.map(this::toEntity);
    }

    public AddressDto toDto(AddressEntity addressEntity) {
        return modelMapper.map(addressEntity, AddressDto.class);
    }

    public AddressEntity toEntity(AddressDto addressDto) {
        return modelMapper.map(addressDto, AddressEntity.class);
    }
}
