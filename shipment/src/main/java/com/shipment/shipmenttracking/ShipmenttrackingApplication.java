package com.shipment.shipmenttracking;

import com.shipment.shipmenttracking.services.Experimental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShipmenttrackingApplication implements CommandLineRunner {

	@Autowired
	private Experimental experimental;
	public static void main(String[] args) {
		SpringApplication.run(ShipmenttrackingApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println(5);
//		this.experimantal.getAll().subscribe(System.out::println);
	}
}
