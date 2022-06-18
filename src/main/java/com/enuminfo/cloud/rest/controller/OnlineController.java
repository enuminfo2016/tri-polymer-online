package com.enuminfo.cloud.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.cloud.rest.RequestPath;
import com.enuminfo.cloud.rest.dto.CatalogProductDto;
import com.enuminfo.cloud.rest.dto.LocationDto;
import com.enuminfo.cloud.service.IOnlineService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.REST_ENDPOINT)
public class OnlineController {
	@Autowired IOnlineService onlineService;
	
	@GetMapping(value = RequestPath.CATALOG_PRODUCTS_BY_CATEGORY)
	public ResponseEntity<List<CatalogProductDto>> handleInternalRequestForCatalogProductsByCategory(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForCatalogProductsByCategory ... ");
		List<CatalogProductDto> ListCatalogProductDtos = onlineService.getProductsByCategory(value);
        HttpStatus httpStatus = (ListCatalogProductDtos != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ListCatalogProductDtos, httpStatus);
	}
	
	@GetMapping (value = RequestPath.COUNTRIES)
	public ResponseEntity<List<String>> handleInteralRequestForAllCountries() {
		log.info("### OnlineController.handleInteralRequestForAllCountries ... ");
		List<String> ListCountries = onlineService.getAllCountries();
        HttpStatus httpStatus = (ListCountries != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ListCountries, httpStatus);
	}
	
	@GetMapping (value = RequestPath.STATES_BY_COUNTRY)
	public ResponseEntity<List<String>> handleInternalRequestForAllStates(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllStates ... ");
		List<String> ListStates = onlineService.getAllStates(value);
        HttpStatus httpStatus = (ListStates != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ListStates, httpStatus);
	}
	
	@GetMapping (value = RequestPath.CITIES_BY_STATE)
	public ResponseEntity<List<String>> handleInternalRequestForAllCities(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllCities ... ");
		List<String> ListCities = onlineService.getAllCities(value);
        HttpStatus httpStatus = (ListCities != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ListCities, httpStatus);
	}
	
	@GetMapping (value = RequestPath.LOCATIONS_BY_CITY)
	public ResponseEntity<List<LocationDto>> handleInternalRequestForAllLocations(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllLocations ... ");
		List<LocationDto> ListLocationDtos = onlineService.getAllLocations(value);
        HttpStatus httpStatus = (ListLocationDtos != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(ListLocationDtos, httpStatus);
	}
	
	@GetMapping(value = RequestPath.CATALOG_PRODUCT_DETAIL_BY_PRODUCT)
	public ResponseEntity<CatalogProductDto> handleInternalRequestForCatalogProductDetailByProduct(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForCatalogProductDetailByProduct ... ");
		CatalogProductDto monoCatalogProductDto = onlineService.getProductDetailByProduct(value);
        HttpStatus httpStatus = (monoCatalogProductDto != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(monoCatalogProductDto, httpStatus);
	}
}
