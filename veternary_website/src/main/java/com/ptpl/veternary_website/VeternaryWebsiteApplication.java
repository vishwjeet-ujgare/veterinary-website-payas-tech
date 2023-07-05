package com.ptpl.veternary_website;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeternaryWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeternaryWebsiteApplication.class, args);
		System.out.println("Application running...");
	}

	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
