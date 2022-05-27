package com.twa.flights.api.catalog.controller.documentation;

import com.twa.flights.api.catalog.dto.BaseDTO;
import com.twa.flights.api.catalog.dto.CountryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Country", description = "Operations about the country")
public interface CountryResources {

    @Operation(description = "Get country by code", responses = {
            @ApiResponse(responseCode = "200", description = "The country information", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BaseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Entity not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error") }, tags = {
                    "Catalog" }, parameters = {
                            @Parameter(in = ParameterIn.PATH, name = "code", description = "The code of the country (e.g. AR, BR, US)", required = true, example = "US") })
    @GetMapping(value = "/country/{code}")
    ResponseEntity<CountryDTO> getCountryByCode(@PathVariable String code);


    @Operation(description = "Save country", responses = {
            @ApiResponse(responseCode = "200", description = "The country information", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = BaseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Validation error"),
            @ApiResponse(responseCode = "500", description = "Internal server error") }, tags = {
            "Catalog" })
    @PostMapping(value = "/country")
    ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country);

}
