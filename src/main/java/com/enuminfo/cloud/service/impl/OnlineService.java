package com.enuminfo.cloud.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.IOnlineService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OnlineService implements IOnlineService {

	@Override
	public Flux<String> getAllCountries() {
		return null;
	}

	@Override
	public Flux<String> getAllStates(String country) {
		return null;
	}

	@Override
	public Flux<String> getAllCities(String state) {
		return null;
	}

	@Override
	public Flux<LocationDto> getAllLocations(String city) {
		return null;
	}

	@Override
	public Mono<LocationDto> getLocationByName(String location) {
		return null;
	}

	@Override
	public Flux<CatalogProductDto> getProductsByCategory(String value) {
		return null;
	}

	@Override
	public Mono<Map<CategoryDto, List<CatalogProductDto>>> getAllProducts() {
		return null;
	}

	@Override
	public Mono<CatalogProductDto> getProductDetailByProduct(String value) {
		return null;
	}
}
