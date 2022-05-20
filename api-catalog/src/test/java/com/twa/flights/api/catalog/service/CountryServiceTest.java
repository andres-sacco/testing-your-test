package com.twa.flights.api.catalog.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.model.Country;
import com.twa.flights.api.catalog.repository.CountryRepository;

import ma.glasnost.orika.MapperFacade;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {
    private static final String DEFAULT_COUNTRY_CODE = "AR";

    private CountryRepository countryRepository;
    private MapperFacade mapper;

    private CountryService countryService;

    @BeforeEach
    public void setUp() {
        countryRepository = mock(CountryRepository.class);
        mapper = mock(MapperFacade.class);
        countryService = new CountryService(countryRepository, mapper);
    }

    @Test
    public void should_return_an_exception() {
        Country country = null;
        when(countryRepository.findByCode(DEFAULT_COUNTRY_CODE)).thenReturn(country);
        assertThrows(APIException.class, () -> countryService.getCountryByCode(DEFAULT_COUNTRY_CODE));
    }
}
