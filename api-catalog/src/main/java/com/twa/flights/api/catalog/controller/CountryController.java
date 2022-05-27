package com.twa.flights.api.catalog.controller;

import com.twa.flights.api.catalog.controller.documentation.CountryResources;
import com.twa.flights.api.catalog.dto.CountryDTO;
import com.twa.flights.api.catalog.enums.ExceptionStatus;
import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CountryController implements CountryResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    private CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity<CountryDTO> getCountryByCode(String code) {
        LOGGER.info("Obtain all the information about the country with code {}", code);
        
        validateCountry(code);

        CountryDTO response = countryService.getCountryByCode(code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CountryDTO> save(CountryDTO country) {
        LOGGER.info("Save all the information about the country {}", country);

        CountryDTO response = countryService.save(country);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
	private void validateCountry(String code) {
		if(code.length() != 2) {
            throw new APIException(HttpStatus.NOT_FOUND,
                    ExceptionStatus.COUNTRY_NOT_FOUND.getCode(),
                    ExceptionStatus.COUNTRY_NOT_FOUND.getMessage());
        }
	}
}
