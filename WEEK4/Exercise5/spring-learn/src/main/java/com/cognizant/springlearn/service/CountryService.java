package com.cognizant.springlearn.service;

import com.cognizant.springlearn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
    private final List<Country> countries;

    public CountryService() {
        // Load the "country.xml" and fetch the countryList bean
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        //noinspection unchecked
        this.countries = (List<Country>) context.getBean("countryList");
        LOGGER.info("Loaded {} countries from XML", countries.size());
    }

    public Country getCountry(String code) {
        LOGGER.info("Searching for country code: {}", code);
        // case-insensitive match
        Optional<Country> match = countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        return match.orElse(null);  // or throw an exception if not found
    }
}
