package com.shipment.shipmenttracking.helpers;

import com.shipment.shipmenttracking.dtos.OrganizationDto;
import com.shipment.shipmenttracking.entities.AddressEntity;
import com.shipment.shipmenttracking.entities.OrganizationEntity;
import com.shipment.shipmenttracking.repositories.AddressRepository;
import com.shipment.shipmenttracking.repositories.CountryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class OrganizationMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CountryRepository countryRepository;

    public Mono<OrganizationDto> toDtoMono(Mono<OrganizationEntity> organizationEntityMono) {
        return organizationEntityMono.flatMap(organizationEntity -> {
            OrganizationDto resultDto = this.modelMapper.map(organizationEntity, OrganizationDto.class);
            return this.addressRepository.findByOrganizationId(organizationEntity.getId())
                    .flatMap(addressEntity -> {
                        resultDto.setAddressDto(this.addressMapper.toDto(addressEntity));
                        return this.countryRepository.findById(addressEntity.getCountryId())
                                .flatMap(countryEntity -> {
                                    resultDto.setCountryDto(this.countryMapper.toDto(countryEntity));
                                    return Mono.just(resultDto);
                                });
                    });

        });
    }

    public Mono<OrganizationEntity> toEntityMono(Mono<OrganizationDto> organizationDtoMono){
        return organizationDtoMono.map(organizationDto -> this.modelMapper
                .map(organizationDto, OrganizationEntity.class));
    }

    public Flux<OrganizationDto> toDtoFlux(Flux<OrganizationEntity> organizationEntityFlux){
        return organizationEntityFlux.flatMap(organizationEntity -> {
            OrganizationDto resultDto = this.modelMapper.map(organizationEntity, OrganizationDto.class);
            return this.addressRepository.findByOrganizationId(organizationEntity.getId())
                    .flatMapMany(addressEntity -> {
                        resultDto.setAddressDto(this.addressMapper.toDto(addressEntity));
                        return this.countryRepository.findById(addressEntity.getCountryId())
                                .flatMapMany(countryEntity -> {
                                    resultDto.setCountryDto(this.countryMapper.toDto(countryEntity));
                                    return Flux.just(resultDto);
                                });
                    });
        });
    }

    public Flux<OrganizationEntity> toEntityFlux(Flux<OrganizationDto> organizationDtoFlux){
        return organizationDtoFlux.map(organizationDto -> this.modelMapper
                            .map(organizationDto, OrganizationEntity.class));
    }
}
