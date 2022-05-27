package com.twa.flights.api.catalog.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twa.flights.api.catalog.dto.ContinentDTO;
import com.twa.flights.api.catalog.dto.CountryDTO;
import com.twa.flights.api.catalog.model.Continent;
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
        when(countryRepository.findByCode(DEFAULT_COUNTRY_CODE)).thenReturn(null);
        assertThrows(APIException.class, () -> countryService.getCountryByCode(DEFAULT_COUNTRY_CODE));
    }

    @Test
    public void should_return_a_country() {
        when(countryRepository.findByCode(DEFAULT_COUNTRY_CODE)).thenReturn(getCountryModel());
        
        CountryDTO response = countryService.getCountryByCode(DEFAULT_COUNTRY_CODE);
    }

    private Country getCountryModel() {
        Country country = new Country();
        country.setCode(DEFAULT_COUNTRY_CODE);
        country.setId(1L);
        country.setName("Argentina");
        Continent continent = getContinentModel();
        country.setContinent(continent);
        return country;
    }

    private Continent getContinentModel() {
        Continent continent = new Continent();
        continent.setCode("SU");
        continent.setId(1L);
        continent.setName("Sud America");
        return continent;
    }


    private CountryDTO getCountryDTO() {
        CountryDTO country = new CountryDTO();
        country.setCode(DEFAULT_COUNTRY_CODE);
        country.setName("Argentina");
        ContinentDTO continent = getContinentDTO();
        country.setContinent(continent);
        return country;
    }

    private ContinentDTO getContinentDTO() {
        ContinentDTO continent = new ContinentDTO();
        continent.setCode("SU");
        continent.setName("Sud America");
        return continent;
    }
}
