package com.twa.flights.api.catalog.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.twa.flights.api.catalog.exception.APIException;
import com.twa.flights.api.catalog.model.City;
import com.twa.flights.api.catalog.repository.CityRepository;

import ma.glasnost.orika.MapperFacade;

@ExtendWith(MockitoExtension.class)
public class CityServiceTest {
    private static final String DEFAULT_CITY_CODE = "BUE";

    private CityRepository cityRepository;
    private MapperFacade mapper;

    private CityService cityService;

    @BeforeEach
    public void setUp() {
        cityRepository = mock(CityRepository.class);
        mapper = mock(MapperFacade.class);
        cityService = new CityService(cityRepository, mapper);
    }

    @Test
    public void should_return_an_exception() {
        when(cityRepository.findByCode(DEFAULT_CITY_CODE)).thenReturn(null);
        assertThrows(APIException.class, () -> cityService.getCityByCode(DEFAULT_CITY_CODE));
    }
}
