/**
 * 
 */
package com.springcloud.microservice.service;

import java.util.List;
import java.util.Map;

import com.springcloud.microservice.rest.dto.CatalogProductDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;

/**
 * @author SIVA KUMAR
 */
public interface IOnlineService {
	
	List<String> getAllCountries();

	List<String> getAllStates(String country);

	List<String> getAllCities(String state);

	List<String> getAllLocations(String city);

	LocationDto getLocationByName(String location);
	
	List<CatalogProductDto> getAllCatalogProductsByCategory(String value);

	Map<CategoryDto, List<CatalogProductDto>> getAllCatalogProducts();
	
	CatalogProductDto getCatalogProductDetailByProduct(String value);
}
