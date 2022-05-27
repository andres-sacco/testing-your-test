package com.twa.flights.api.catalog.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.twa.flights.api.catalog.dto.CountryDTO;
import com.twa.flights.api.catalog.service.CountryService;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {

    private static final String DEFAULT_COUNTRY_CODE = "AR";
    private CountryService countryService;
    private CountryController controller;

    @BeforeEach
    public void setUp() {
        countryService = mock(CountryService.class);
        controller = new CountryController(countryService);
    }

    @Test
    public void should_return_a_country() {
        CountryDTO country = new CountryDTO();
        country.setCode(DEFAULT_COUNTRY_CODE);

        when(countryService.getCountryByCode(DEFAULT_COUNTRY_CODE)).thenReturn(country);
        ResponseEntity<CountryDTO> response = controller.getCountryByCode(DEFAULT_COUNTRY_CODE);

        assertAll(() -> assertNotNull(response),
                () -> assertEquals(200, response.getStatusCodeValue()),
                () -> assertEquals(DEFAULT_COUNTRY_CODE, response.getBody().getCode()));
    }
}
