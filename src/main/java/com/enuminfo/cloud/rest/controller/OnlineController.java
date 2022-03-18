package com.enuminfo.cloud.rest.controller;

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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = RequestPath.REST_ENDPOINT)
public class OnlineController {
	@Autowired IOnlineService onlineService;
	
	@GetMapping(value = RequestPath.CATALOG_PRODUCTS_BY_CATEGORY)
	public ResponseEntity<Flux<CatalogProductDto>> handleInternalRequestForCatalogProductsByCategory(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForCatalogProductsByCategory ... ");
		Flux<CatalogProductDto> fluxCatalogProductDtos = onlineService.getProductsByCategory(value);
        HttpStatus httpStatus = (fluxCatalogProductDtos != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxCatalogProductDtos, httpStatus);
	}
	
	@GetMapping (value = RequestPath.COUNTRIES)
	public ResponseEntity<Flux<String>> handleInteralRequestForAllCountries() {
		log.info("### OnlineController.handleInteralRequestForAllCountries ... ");
		Flux<String> fluxCountries = onlineService.getAllCountries();
        HttpStatus httpStatus = (fluxCountries != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxCountries, httpStatus);
	}
	
	@GetMapping (value = RequestPath.STATES_BY_COUNTRY)
	public ResponseEntity<Flux<String>> handleInternalRequestForAllStates(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllStates ... ");
		Flux<String> fluxStates = onlineService.getAllStates(value);
        HttpStatus httpStatus = (fluxStates != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxStates, httpStatus);
	}
	
	@GetMapping (value = RequestPath.CITIES_BY_STATE)
	public ResponseEntity<Flux<String>> handleInternalRequestForAllCities(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllCities ... ");
		Flux<String> fluxCities = onlineService.getAllCities(value);
        HttpStatus httpStatus = (fluxCities != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxCities, httpStatus);
	}
	
	@GetMapping (value = RequestPath.LOCATIONS_BY_CITY)
	public ResponseEntity<Flux<LocationDto>> handleInternalRequestForAllLocations(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForAllLocations ... ");
		Flux<LocationDto> fluxLocationDtos = onlineService.getAllLocations(value);
        HttpStatus httpStatus = (fluxLocationDtos != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(fluxLocationDtos, httpStatus);
	}
	
	@GetMapping(value = RequestPath.CATALOG_PRODUCT_DETAIL_BY_PRODUCT)
	public ResponseEntity<Mono<CatalogProductDto>> handleInternalRequestForCatalogProductDetailByProduct(@PathVariable String value) {
		log.info("### OnlineController.handleInternalRequestForCatalogProductDetailByProduct ... ");
		Mono<CatalogProductDto> monoCatalogProductDto = onlineService.getProductDetailByProduct(value);
        HttpStatus httpStatus = (monoCatalogProductDto != null) ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(monoCatalogProductDto, httpStatus);
	}
}
