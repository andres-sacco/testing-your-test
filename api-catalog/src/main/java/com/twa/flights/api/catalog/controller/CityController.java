package com.twa.flights.api.catalog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twa.flights.api.catalog.controller.documentation.CityResources;
import com.twa.flights.api.catalog.dto.CityDTO;
import com.twa.flights.api.catalog.enums.ExceptionStatus;
import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.service.CityService;

@RestController
@RequestMapping("/")
public class CityController implements CityResources {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @Override
    public ResponseEntity<CityDTO> getCityByCode(String code) {
        LOGGER.info("Obtain all the information about the city with code {}", code);

        validateCity(code);
        
        CityDTO response = cityService.getCityByCode(code);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CityDTO> save(CityDTO city) {
        LOGGER.info("Save all the information about the city {}", city);

        CityDTO response = cityService.save(city);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

	private void validateCity(String code) {
		if(code.length() != 3) {
            throw new APIException(HttpStatus.NOT_FOUND,
                    ExceptionStatus.CITY_NOT_FOUND.getCode(),
                    ExceptionStatus.CITY_NOT_FOUND.getMessage());
        }
	}
}
