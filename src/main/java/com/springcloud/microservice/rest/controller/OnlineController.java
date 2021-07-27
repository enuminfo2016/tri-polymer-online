/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.IRequestPath;
import com.springcloud.microservice.rest.dto.CatalogProductDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.service.IOnlineService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = IRequestPath.UNSECURED_REST_ENDPOINT)
public class OnlineController {

	private static final Logger log = LoggerFactory.getLogger(OnlineController.class);
	@Autowired IOnlineService onlineService;
	
	@GetMapping(value = IRequestPath.CATALOG_PRODUCTS_BY_CATEGORY)
	public List<CatalogProductDto> handleInternalRequestForWeeklyCatalogProduct(@PathVariable String value) {
		log.info("### AdminController.handleInternalRequestForWeeklyCatalogProduct ... ");
		return onlineService.getAllCatalogProductsByCategory(value);
	}
	
	@GetMapping (value = IRequestPath.COUNTRIES)
	public List<String> handleInteralRequestForAllCountries() {
		log.info("### AdminController.handleInteralRequestForAllCountries ... ");
		return onlineService.getAllCountries();
	}
	
	@GetMapping (value = IRequestPath.STATES_BY_COUNTRY)
	public List<String> handleInternalRequestForAllStates(@PathVariable String value) {
		log.info("### AdminController.handleInternalRequestForAllStates ... ");
		return onlineService.getAllStates(value);
	}
	
	@GetMapping (value = IRequestPath.CITIES_BY_STATE)
	public List<String> handleInternalRequestForAllCities(@PathVariable String value) {
		log.info("### AdminController.handleInternalRequestForAllCities ... ");
		return onlineService.getAllCities(value);
	}
	
	@GetMapping (value = IRequestPath.PIN_BY_LOCATION)
	public List<String> handleInternalRequestForAllLocations(@PathVariable String value) {
		log.info("### AdminController.handleInternalRequestForAllLocations ... ");
		return onlineService.getAllLocations(value);
	}

	@GetMapping(value = IRequestPath.CATALOG_PRODUCTS)
	public Map<CategoryDto, List<CatalogProductDto>> handleInternalRequestForCatalogProducts() {
		log.info("### AdminController.handleInternalRequestForCatalogProducts ... ");
		return onlineService.getAllCatalogProducts();
	}
}
