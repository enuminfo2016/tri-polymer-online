package com.enuminfo.cloud.service;

import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.CategoryDto;
import com.enuminfo.cloud.rest.dto.LocationDto;

import java.util.List;
import java.util.Map;

public interface IOnlineService {
	List<String> getAllCountries();

	List<String> getAllStates(String country);

	List<String> getAllCities(String state);

	List<LocationDto> getAllLocations(String city);

	List<CatalogProductDto> getProductsByCategory(String value);

	Map<CategoryDto, List<CatalogProductDto>> getAllProducts();

	CatalogProductDto getProductDetailByProduct(String value);
}
