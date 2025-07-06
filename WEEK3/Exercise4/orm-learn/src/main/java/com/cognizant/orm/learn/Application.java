package com.cognizant.orm.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm.learn.service.CountryService;
import com.cognizant.orm.learn.model.Country;

@SpringBootApplication
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	// static reference for testing
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		LOGGER.info("Inside main");

		// grab your service from Spring
		countryService = context.getBean(CountryService.class);

		// test
		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start testGetAllCountries");
		countryService.getAllCountries()
				.forEach(country -> LOGGER.debug("Country -> {}", country));
		LOGGER.info("End testGetAllCountries");
	}
}
