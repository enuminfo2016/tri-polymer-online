package com.enuminfo.cloud.service;

import java.util.List;
import java.util.Map;

import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.rest.dto.LocationDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOnlineService {
	Flux<String> getAllCountries();
	Flux<String> getAllStates(String country);
	Flux<String> getAllCities(String state);
	Flux<LocationDto> getAllLocations(String city);
	Mono<LocationDto> getLocationByName(String location);
	
	Flux<CatalogProductDto> getProductsByCategory(String value);
	Mono<Map<CategoryDto, List<CatalogProductDto>>> getAllProducts();
	Mono<CatalogProductDto> getProductDetailByProduct(String value);
}
