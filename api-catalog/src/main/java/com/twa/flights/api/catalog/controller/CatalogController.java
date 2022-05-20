package com.twa.flights.api.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twa.flights.api.catalog.controller.documentation.CatalogResources;
import com.twa.flights.api.catalog.dto.CityDTO;
import com.twa.flights.api.catalog.dto.CountryDTO;
import com.twa.flights.api.catalog.enums.ExceptionStatus;
import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.service.CityService;
import com.twa.flights.api.catalog.service.CountryService;

@RestController
@RequestMapping("/")
public class CatalogController implements CatalogResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    private CityService cityService;
    private CountryService countryService;

    @Autowired
    public CatalogController(CityService cityService, CountryService countryService) {
        this.cityService = cityService;
        this.countryService = countryService;
    }

    @Override
    public ResponseEntity<CityDTO> getCityByCode(String code) {
        LOGGER.info("Obtain all the information about the city with code {}", code);

        validateCity(code);
        
        CityDTO response = cityService.getCityByCode(code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	private void validateCity(String code) {
		if(code.length() != 3) {
            throw new APIException(HttpStatus.NOT_FOUND, ExceptionStatus.CITY_NOT_FOUND.getCode(),
                    ExceptionStatus.CITY_NOT_FOUND.getMessage());
        }
	}

    @Override
    public ResponseEntity<CountryDTO> getCountryByCode(String code) {
        LOGGER.info("Obtain all the information about the country with code {}", code);
        
        validateCountry(code);

        CountryDTO response = countryService.getCountryByCode(code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
	private void validateCountry(String code) {
		if(code.length() != 2) {
            throw new APIException(HttpStatus.NOT_FOUND, ExceptionStatus.COUNTRY_NOT_FOUND.getCode(),
                    ExceptionStatus.COUNTRY_NOT_FOUND.getMessage());
        }
	}
}
