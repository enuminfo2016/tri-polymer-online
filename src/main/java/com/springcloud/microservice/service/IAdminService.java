/**
 * 
 */
package com.springcloud.microservice.service;

import java.text.ParseException;
import java.util.List;

import com.springcloud.microservice.rest.dto.CatalogDto;
import com.springcloud.microservice.rest.dto.CategoryDto;
import com.springcloud.microservice.rest.dto.LocationDto;
import com.springcloud.microservice.rest.dto.ProductDto;

/**
 * @author SIVA KUMAR
 */
public interface IAdminService {

	void saveCategory(CategoryDto dto) throws ParseException;

	List<CategoryDto> getAllCategories();

	void removeCategory(long id);

	void saveProduct(ProductDto dto) throws ParseException;

	List<ProductDto> getAllProducts();

	void removeProduct(long id);

	void saveCatalog(CatalogDto dto) throws ParseException;

	List<CatalogDto> getAllCatalogs();

	void removeCatalog(long id);

	List<LocationDto> getAllDeliveryLocations();

	void saveDeliveryLocation(LocationDto dto) throws ParseException;

	List<LocationDto> getAllDeliveryLocations(String location);
}
