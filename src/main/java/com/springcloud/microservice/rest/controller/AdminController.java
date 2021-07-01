/**
 * 
 */
package com.springcloud.microservice.rest.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.microservice.rest.IRequestPath;
import com.springcloud.microservice.rest.dto.CatalogDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;
import com.springcloud.microservice.rest.dto.ProductDto;
import com.springcloud.microservice.service.IAdminService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author SIVA KUMAR
 */
@Slf4j
@RestController
@RequestMapping(value = IRequestPath.SECURED_REST_ENDPOINT)
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	@Autowired IAdminService adminService;

	@GetMapping(value = IRequestPath.CATEGORIES)
	public List<CategoryDto> handleInternalRequestForAllCategories() {
		log.info("### AdminController.handleInternalRequestForAllCategories ... ");
		return adminService.getAllCategories();
	}
	
	@PostMapping(value = IRequestPath.CATEGORIES)
	public void handleInternalRequestForSaveCategory(@RequestBody CategoryDto dto) {
		try {
			log.info("### AdminController.handleInternalRequestForSaveCategory ... ");
			adminService.saveCategory(dto);
		} catch (ParseException e) {
			log.error("### AdminController.handleInternalRequestForSaveCategory ... {}", e.getMessage());
		}
	}
	
	@GetMapping(value = IRequestPath.PRODUCTS)
	public List<ProductDto> handleInternalRequestForAllProducts() {
		log.info("### AdminController.handleInternalRequestForAllProducts ... ");
		return adminService.getAllProducts();
	}
	
	@PostMapping(value = IRequestPath.PRODUCTS)
	public void handleInternalRequestForSaveProduct(@RequestBody ProductDto dto) {
		try {
			log.info("### AdminController.handleInternalRequestForSaveProduct ... ");
			adminService.saveProduct(dto);
		} catch (ParseException e) {
			log.error("### AdminController.handleInternalRequestForSaveProduct ... {}", e.getMessage());
		}
	}
	
	@GetMapping(value = IRequestPath.CATALOG)
	public List<CatalogDto> handleInternalRequestForAllCatalogs() {
		log.info("### AdminController.handleInternalRequestForAllCatalogs ... ");
		return adminService.getAllCatalogs();
	}
	
	@PostMapping(value = IRequestPath.CATALOG)
	public void handleInternalRequestForSaveCatalog(@RequestBody CatalogDto dto) {
		try {
			log.info("### AdminController.handleInternalRequestForSaveCatalog ... ");
			adminService.saveCatalog(dto);
		} catch (ParseException e) {
			log.error("### AdminController.handleInternalRequestForSaveCatalog ... {}", e.getMessage());
		}
	}
	
	@GetMapping (value = IRequestPath.DELIVERY_LOCATIONS)
	public List<LocationDto> handleInteralRequestForAllDeliveryLocations() {
		log.info("### AdminController.handleInteralRequestForAllDeliveryLocations ... ");
		return adminService.getAllDeliveryLocations();
	}
	
	@GetMapping (value = IRequestPath.DELIVERY_LOCATIONS_BY_LOCATION)
	public List<LocationDto> handleInteralRequestForAllDeliveryLocationsByLocation(@PathVariable String value) {
		log.info("### AdminController.handleInteralRequestForAllDeliveryLocationsByLocation ... ");
		return adminService.getAllDeliveryLocations(value);
	}
	
	@PostMapping(value = IRequestPath.DELIVERY_LOCATIONS)
	public void handleInternalRequestForSaveDeliveryLocation(@RequestBody LocationDto dto) {
		try {
			log.info("### AdminController.handleInternalRequestForSaveDeliveryLocation ... ");
			adminService.saveDeliveryLocation(dto);
		} catch (ParseException e) {
			log.error("### AdminController.handleInternalRequestForSaveDeliveryLocation ... {}", e.getMessage());
		}
	}
}
