package com.twa.flights.api.catalog.configuration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class InfoEndpointConfigurationTest {

    @Test
    public void should_return_not_null_info_endpoint() {
        InfoEndpointConfiguration infoEndpointConfiguration = new InfoEndpointConfiguration();
        assertNotNull(infoEndpointConfiguration.infoEndpoint());
    }
}
