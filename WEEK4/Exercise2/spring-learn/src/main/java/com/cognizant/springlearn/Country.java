package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
    private String code;
    private String name;

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    public Country() {
        LOGGER.info("Inside Country Constructor.");
    }

    public String getCode() {
        LOGGER.info("Getter for code called.");
        return code;
    }

    public void setCode(String code) {
        LOGGER.info("Setter for code called.");
        this.code = code;
    }

    public String getName() {
        LOGGER.info("Getter for name called.");
        return name;
    }

    public void setName(String name) {
        LOGGER.info("Setter for name called.");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
