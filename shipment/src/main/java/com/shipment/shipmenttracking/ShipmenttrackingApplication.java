package com.shipment.shipmenttracking;

import com.shipment.shipmenttracking.entities.CountryEntity;
import com.shipment.shipmenttracking.helpers.CountryMapper;
import com.shipment.shipmenttracking.services.Experimental;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShipmenttrackingApplication implements CommandLineRunner {

	@Autowired
	private Experimental experimental;

	@Autowired
	private CountryMapper countryMapper;

	public static void main(String[] args) {
		SpringApplication.run(ShipmenttrackingApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
//		this.experimental.getAll().subscribe(System.out::println);
		CountryEntity countryEntity = new CountryEntity();
		countryEntity.setId(12);
		countryEntity.setCode("asd");
		countryEntity.setName("ABC");

		System.out.println(this.countryMapper.toDto(countryEntity));
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
