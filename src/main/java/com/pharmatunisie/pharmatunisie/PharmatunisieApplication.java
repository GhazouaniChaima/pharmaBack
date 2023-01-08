package com.pharmatunisie.pharmatunisie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pharmatunisie.pharmatunisie.entity.MedicamentEntity;
import com.pharmatunisie.pharmatunisie.repository.MedicamentDao;

@SpringBootApplication
public class PharmatunisieApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PharmatunisieApplication.class, args);
	}
}
