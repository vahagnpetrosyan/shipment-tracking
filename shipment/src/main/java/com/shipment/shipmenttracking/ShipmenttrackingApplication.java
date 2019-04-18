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
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class ShipmenttrackingApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(ShipmenttrackingApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
